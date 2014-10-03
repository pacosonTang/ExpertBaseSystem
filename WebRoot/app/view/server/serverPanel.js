//用户界面
Ext.onReady(function(){
	Ext.QuickTips.init();
	
	//将整个body分为3部分，top显示Logo，west显示菜单，main显示内容
	Ext.create('Ext.container.Viewport', {
		layout : 'border',
		frame : true,
		items : [{
			collapsible : false,
			contentEl : 'top',
			region : 'north',
			height : 30,
		}, {
			title : '功能菜单',
			items : serverMenu,
			split : true,
			collapsible : true,
			contentEl : 'menu',
			region : 'west',
			width : 200
		}, {
			title : '欢迎',
			contentEl : 'main',
			collapsible : false,
			bodyStyle : 'background:#DFE9F5;',
			id : 'mainContent',
			region : 'center'
		} , {
			collapsible : false,
			contentEl : 'bottom',
			region : 'south',
			height : 30,
		} , {
			collapsible : false,
			contentEl : 'space',
			region : 'east',
			width : 2,
		}]
	});
	
	var mainPanel = Ext.getCmp('mainContent');//获取主面板

	//显示用户信息的json读取器
	var leaderJsonReader = Ext.create('Ext.data.JsonReader', {
		root : 'list',
	    totalProperty : 'totalCount',
	    id : 'id',
	    successProperty : '@success',
	    model : 'Server'
	});
	var showUser = Ext.create("Ext.form.Panel", {
		title : '我的资料',
		frame : true,
		height : 200,
		width : 700,
		style : 'margin-left:20%;margin-top:8%;',
		reader : leaderJsonReader,
		buttonAlign : 'center',
		defaults : {
			labelSeparator : ' : ',
			labelAlign : 'right',
			labelWidth : 60
		},
		layout : {
			type : 'table',
			columns : 3,
		},
		items : [{
			xtype : 'textfield',
			fieldLabel : '姓名',
			name : 'user.realname',
			id : 'realname',
			maxLength : 20,
			allowBlank : false,
		}, {
			xtype : 'combobox',
			fieldLabel : '性别',
			name : 'user.sex',
			id : 'sex',
			allowBlank : false,
			emptyText : '请选择',
			queryMode : 'local',//本地选择模式
			store : Ext.data.StoreManager.lookup('SexStore'),
			valueField : 'sexname',
			displayField : 'sexname',
			forceSelection : true,
			typeAhead : true,
		}, {
			xtype : 'textfield',
			fieldLabel : '职务',
			name : 'user.duty',
			id : 'duty',
		}, {
			xtype : 'textfield',
			fieldLabel : '工作单位',
			name : 'user.workUnit',
			id : 'workUnit',
			colspan : 2,
			width : 470,
			allowBlank : false,
		}, {
			xtype : 'textfield',
			fieldLabel : '邮编',
			name : 'user.postcode',
			id : 'postcode',
			maxValue : 6,
			minValue : 6
		}, {
			xtype : 'textfield',
			fieldLabel : '通讯地址',
			name : 'user.address',
			id : 'address',
			width : 470,
			colspan : 2
		}, {
			xtype : 'textfield',
			fieldLabel : '手机',
			name : 'user.telephone',
			id : 'telephone',
			allowBlank : false,
			maxLength : 11,
			regex : /^[1][3-8]+\d{9}/,
			regexText : '请输入正确的手机号',
		}, {
			xtype : 'textfield',
			fieldLabel : '电子邮箱',
			name : 'user.email',
			id : 'email',
			colspan : 2,
			width : 470,
			regex : /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/,
			regexText : '邮箱格式为XXX@XXX.com',
		}, {
			xtype : 'textfield',
			fieldLabel : '办公电话',
			name : 'user.officePhone',
			id : 'officePhone',
		}],
		buttons : [{
			text : '保存',
			iconCls : 'save',
			disabled : false,
			handler : function(btn){
				saveMe(btn.ownerCt.ownerCt);
			}
		}]
	});
	
	//为修改密码提供的自定义数据验证
	Ext.apply(Ext.form.field.VTypes, {
		pass : function(value, field){
			if(field.confirmTo){
				var pwd=Ext.getCmp(field.confirmTo);
				if(value == pwd.getValue()){
					return true;
				} else {
					return false;
				}
			}
		},
		passText : '两次密码输入不同'
	});
	var modifyCountFP = Ext.create("Ext.form.Panel", {
		title : '修改账户',
		frame : true,
		height : 200,
		width : 250,
		style : 'margin-left:35%;margin-top:10%;',
		buttonAlign : 'center',
		defaults : {
			labelSeparator : ' : ',
			labelAlign : 'right',
			labelWidth : 60
		},
		items : [{
			xtype : 'textfield',
			fieldLabel : '用户名',
			name : 'userDTO.username',
			value : username,
			allowBlank : false
		}, {
			xtype : 'textfield',
			fieldLabel : '原密码',
			name : 'userDTO.password',
			inputType : 'password',
			allowBlank : false
		}, {
			xtype : 'textfield',
			fieldLabel : '新密码',
			name : 'userDTO.newpass',
			id : 'newpass',
			allowBlank : false,
			maxLength : 20,
			inputType : 'password',
			regex : /^[\w]{6,}$/,
			regexText : '密码只能包含数字、字母、下划线，长度不少于6位',
			msgTarget : 'side'
		}, {
			xtype : 'textfield',
			fieldLabel : '确认密码',
			name : 'userDTO.confirmpass',
			maxLength : 20,
			inputType : 'password',
			regex : /^[\w]{6,}$/,
			regexText : '密码只能包含数字、字母、下划线，长度不少于6位',
			msgTarget : 'side',
			vtype : 'pass',
			confirmTo : 'newpass'
		}],
		buttons : [{
			text : '保存',
			iconCls : 'save',
			disabled : false,
			handler : function(btn){
				modifyCount(btn.ownerCt.ownerCt);
			}
		}]
	});
	
	/**
	 * 添加会员
	 */
	var memberWindow = Ext.create("Ext.window.Window", {
		title : '会员详情',
		plain : true,
		layout : 'fit',
		closeAction : 'hide',
		resizable : false,
		width : 860,
		height : 500,
		modal : true,
		items : [{
			xtype : 'form',
			frame : true,
			autoScroll : true,
			buttonAlign : 'center',
			defaults : {
				labelSeparator : ' : ',
				labelAlign : 'right',
				labelWidth : 85,
				readOnly : true
			},
			defaultType : 'textfield',
			layout : {
				type : 'table',
				columns : 4,
			},
			items : [{
				xtype : 'image',
				width : 100,
				height : 134,
				src : 'img/nopicture.jpg',
				rowspan : 4
			}, {
				fieldLabel : '姓名',
				name : 'user.realname'
			}, {
				fieldLabel : '性别',
				name : 'user.sex'
			}, {
				fieldLabel : '出生日期',
				name : 'user.birthday'
			}, {
				fieldLabel : '身份证号',
				name : 'user.idNo',
				colspan : 2,
				width : 470
			}, {
				fieldLabel : '学历',
				name : 'user.education.name'
			}, {
				fieldLabel : '毕业院校',
				name : 'user.school',
				colspan : 2,
				width : 470
			}, {
				fieldLabel : '毕业时间',
				name : 'user.graduateTime'
			}, {
				fieldLabel : '所学专业',
				name : 'user.major.name'
			}, {
				fieldLabel : '学位',
				name : 'user.degree.name'
			}, {
				fieldLabel : '所属学会/协会',
				name : 'user.institution.name'
			}, {
				fieldLabel : '工作单位',
				name : 'user.workUnit',
				style : 'margin-top:10px;',
				colspan : 2,
				width : 340
			}, {
				fieldLabel : '专业技术职称',
				name : 'user.title',
				style : 'margin-top:10px;'
			}, {
				fieldLabel : '职务',
				name : 'user.duty',
				style : 'margin-top:10px;'
			}, {
				fieldLabel : '通讯地址',
				name : 'user.address',
				style : 'margin-top:10px;',
				width : 340,
				colspan : 2
			}, {
				fieldLabel : '手机',
				name : 'user.telephone',
				style : 'margin-top:10px;'
			}, {
				fieldLabel : '办公电话',
				name : 'user.officePhone',
				style : 'margin-top:10px;'
			}, {
				fieldLabel : '电子邮箱',
				name : 'user.email',
				style : 'margin-top:10px;',
				colspan : 2,
				width : 340
			}, {
				fieldLabel : '邮编',
				name : 'user.postcode',
				style : 'margin-top:10px;'
			}, {
				fieldLabel : 'QQ号',
				name : 'user.qq',
				style : 'margin-top:10px;'
			}, {
				xtype : 'textarea',
				fieldLabel : '现从事专业',
				name : 'user.currentMajor',
				colspan : 2,
				autoScroll : true,
				style : 'margin-top:10px;',
				width : 340
			}, {
				xtype : 'textarea',
				fieldLabel : '擅长领域',
				name : 'user.adept',
				style : 'margin-top:10px;',
				width : 480,
				autoScroll : true,
				colspan : 2
			}, {
				xtype : 'gridpanel',
				name : 'thesis',
				colspan : 4,
				width : 820,
				height : 200,
				title : '论文',
				columns : [
				    {xtype : 'rownumberer'},
				    {text:'论文名称', dataIndex:'name', width : 710},
					{text:'收录日期', dataIndex:'pubTime', width :70}
				],
				store : Ext.data.StoreManager.lookup('ThesisStore'),
				frame : true,
				loadMask : true
			}, {
				xtype : 'gridpanel',
				name : 'patent',
				colspan : 4,
				width : 820,
				height : 200,
				title : '专利',
				columns : [
				    {xtype : 'rownumberer'},
				    {text:'专利名称', dataIndex:'name', width : 550},
					{text:'授权日期', dataIndex:'authorityTime', width :80},
					{text:'专利号', dataIndex:'patentNo', width : 150}
				],
				store : Ext.data.StoreManager.lookup('PatentStore'),
				frame : true,
				loadMask : true
			}, {
				xtype : 'gridpanel',
				name : 'project',
				colspan : 4,
				width : 820,
				height : 200,
				title : '项目',
				columns : [
				    {xtype : 'rownumberer'},
				    {text:'项目名称', dataIndex:'name', width : 230},
					{text:'项目时间', dataIndex:'projectTime', width :100},
					{text:'本人作用', dataIndex:'selfFunc', width : 80},
					{text:'委托单位', dataIndex:'delegationUnit', width : 120},
					{text:'项目级别', dataIndex:'projectLevel', width : 60,
						renderer : function(value){
							if(value == 0){
								return '国家级';
							} else if(value == 1){
								return '省级';
							} else
								return '市级';
						}
					},
					{text:'项目状态', dataIndex:'completeStatus', width : 80, 
						renderer : function(value){
							if(value == 0){
								return '已验收';
							} else if(value == 1){
								return '完成未验收';
							} else
								return '在研';
						}
					},
					{text:'财政拨款', dataIndex:'allocation', width : 60},
					{text:'自筹', dataIndex:'selffinance', width : 40}
				],
				store : Ext.data.StoreManager.lookup('ProjectStore'),
				frame : true,
				loadMask : true
			}, {
				xtype : 'gridpanel',
				name : 'award',
				colspan : 4,
				width : 820,
				height : 200,
				title : '奖励',
				columns : [
				    {xtype : 'rownumberer'},
				    {text:'奖励名称', dataIndex:'name', width : 350},
					{text:'成果名称', dataIndex:'fruitName', width :300},
					{text:'获奖时间', dataIndex:'awardTime', width : 90},
					{text:'排名', dataIndex:'rank', width : 40},
				],
				store : Ext.data.StoreManager.lookup('AwardStore'),
				frame : true,
				loadMask : true
			}],
			buttons : [{
				text : '确定',
				iconCls : 'save',
				disabled : false,
				handler : function(){
					memberWindow.hide();
				}
			}]
		}]
	});
	
	var UserPanel = Ext.create("Ext.panel.Panel", {
		title : '会员查询',
		layout : 'fit',
		style : 'margin:5px 2% 0;',
		width : 1120,
		heigth : 540,
		frame : true,
		items : [{
			xtype : 'form',
			width : 1100,
			height : 100,
		}, {
			xtype : 'gridpanel',
			width : 1110,
			height : 410,
			columns : [
				{xtype : 'rownumberer'},
				{text:'姓名', dataIndex:'realname', width : 60},
				{text:'性别', dataIndex:'sex', width : 40},
				{text:'专业技术职称', dataIndex:'title', width : 80},
				{text:'毕业院校', dataIndex:'school', width : 80},
				{text:'学历', dataIndex:'education.name', width : 60},
				{text:'学位', dataIndex:'degree.name', width : 60},
				{text:'所学专业', dataIndex:'major.name', width : 80},
				{text:'邮箱', dataIndex:'email', width : 120},
				{text:'手机', dataIndex:'telephone', width : 80},
				{text:'办公电话', dataIndex:'officePhone', width : 80},
				{text:'通讯地址', dataIndex:'address', width : 160},
				{text:'工作单位', dataIndex:'workUnit', width : 100},
				{header : "操作", xtype : 'actioncolumn', width : 40,
					items : [{
						icon : 'img/look.ico',
						tooltip : '查看',
						handler : function(grid, row, col){
							showMember(grid, row, memberWindow);
						}
					}]
				}
			],
			store : Ext.data.StoreManager.lookup('UserStore'),
			dockedItems : [{
				xtype : 'pagingtoolbar',
				store : Ext.data.StoreManager.lookup('UserStore'),
				dock : 'bottom',
				displayInfo : true
			}],
			frame : true,
			loadMask : true
		}]
	});
	
	//为树形菜单增加单击时间，根据id判断要添加的面板
	serverMenu.on({
		'itemclick' : function(view, record, item, index, event, options){
			if(record.get('leaf')){
				showMe(record, mainPanel, showUser);
				showCount(record, mainPanel, modifyCountFP);
				showUsers(record, mainPanel, UserPanel, Ext.data.StoreManager.lookup('UserStore'));
				//消除HTML div上的内容
				var mainDiv = Ext.getDom('main');
				mainDiv.innerHTML = '';
			}
		}
	});
});