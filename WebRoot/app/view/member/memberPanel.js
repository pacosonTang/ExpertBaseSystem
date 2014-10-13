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
			title : '菜单',
			items : memberMenu,
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
	
	/**
	 * 专业学科目录选择窗口
	 */
	var subjectWindow = Ext.create("Ext.window.Window", {
		plain : true,
		layout : 'fit',
		resizable : false,
		closeAction : 'hide',
		modal : true,
		items : [{
			xtype : 'form',
			frame : true,
			width : 670,
			height : 80,
			buttonAlign : 'center',
			layout : {
				type : 'table',
				columns : 3
			},
			defaults : {
				labelSeparator : ' : ',
				labelAlign : 'right',
				labelWidth : 60
			},
			items : [{
				xtype : 'combobox',
				fieldLabel : '一级学科',
				name : 'firstSubject',
				id : 'firstSubject',
				emptyText : '请选择',
				queryMode : 'remote',
				allowBlank : false,
				msgTarget : 'under',
				store : Ext.data.StoreManager.lookup('FirstMajorStore'),
				valueField : 'id',
				displayField : 'name',
				forceSelection : true,
				typeAhead : true,
				listeners : {
					select : function(combo, record, opt){
						var comS = Ext.getCmp('secondSubject');
						var comT = Ext.getCmp('thirdSubject');
						comT.setReadOnly(true);
						comT.clearValue();
						comS.setReadOnly(false);
						comS.clearValue();
						comS.store.load({
							params : {
								subjectId : combo.getValue()
							}
						});
					}
				}
			}, {
				xtype : 'combobox',
				fieldLabel : '二级学科',
				name : 'secondSubject',
				id : 'secondSubject',
				readOnly : true,
				defaultListConfig : {
					loadMask : false
				},
				emptyText : '请选择',
				queryMode : 'local',
				allowBlank : false,
				msgTarget : 'under',
				store : Ext.data.StoreManager.lookup('SecondMajorStore'),
				valueField : 'id',
				displayField : 'name',
				forceSelection : true,
				typeAhead : true,
				listeners : {
					select : function(combo, record, opt){
						var com = Ext.getCmp('thirdSubject');
						com.setReadOnly(false);
						com.clearValue();
						com.store.load({
							params : {
								subjectId : combo.getValue()
							}
						});
					}
				}
			}, {
				xtype : 'combobox',
				fieldLabel : '三级学科',
				name : 'thirdSubject',
				id : 'thirdSubject',
				readOnly : true,
				defaultListConfig : {
					loadMask : false
				},
				emptyText : '请选择',
				queryMode : 'local',
				allowBlank : false,
				msgTarget : 'under',
				store : Ext.data.StoreManager.lookup('ThirdMajorStore'),
				valueField : 'id',
				displayField : 'name',
				forceSelection : true,
				typeAhead : true
			}],
			buttons : [{
				text : '确定',
				iconCls : 'save',
				disabled : false,
				handler : function(){
					var comboValue = subjectWindow.down('form').form.findField('thirdSubject').getValue();
					var record;
				    combo.getStore().each(function(r){
				        if(r.get('id') == combo.getValue()){
				            record = r;
				            return false;
				        }
				    });
					addMemberWindow.down('form').form.findField('user.major.id').setValue(comboValue + "-" + record.get('name'));
					subjectWindow.hide();
				}
			}]
		}]
	});
	
	var imgUploadWindow = Ext.create("Ext.window.Window", {
		title : '上传照片',
		plain : true,
		closeAction : 'hide',
		resizable : false,
		modal : true,
		items : [{
			xtype : 'form',
			frame : true,
			width : 250,
			height : 80,
			buttonAlign : 'center',
			defaults : {
				labelSeparator : ' : ',
				labelAlign : 'right',
				labelWidth : 90
			},
			items : [{
				xtype : 'textfield',
				fieldLabel : '选择照片<200K',
				inputType : 'file',
				name : 'img',
				id : 'img',
				allowBlank : false,
				msgTarget : 'under',
				regex : /\.(jpg|gif|bmp|png|JPG|GIF|BMP|PNG)/,
				regexText : '图片格式只能为.jpg/.gif/.bmp/.png',
			}],
			buttons : [{
				text : '上传',
				iconCls : 'save',
				disabled : false,
				handler : function(){
					savaImg(imgUploadWindow.down('form'), showUser, userId);
				}
			}]
		}]
	});
	
	/**
	 * 显示用户信息并提供修改信息支持的form
	 */
	//显示用户信息的json读取器
	var userJsonReader = Ext.create('Ext.data.JsonReader', {
		root : 'list',
	    totalProperty : 'totalCount',
	    id : 'id',
	    successProperty : '@success',
	    model : 'User'
	});
	//显示用户信息的窗体
	var showUser = Ext.create('Ext.form.Panel', {
		title : '我的信息',
		frame : true,
		//height : 450,
		width : 850,
		style : 'margin-left:15%;margin-top:5%;',
		reader : userJsonReader,
		buttonAlign : 'center',
		defaults : {
			labelSeparator : ' : ',
			labelAlign : 'right',
			labelWidth : 85
		},
		layout : {
			type : 'table',
			columns : 4
		},
		items : [{
			xtype : 'image',
			name : 'user.avatar',
			width : 100,
			height : 134,
			src : 'img/nopicture.jpg',
			rowspan : 4
		}, {
			xtype : 'textfield',
			fieldLabel : '姓名',
			name : 'user.realname',
			id : 'realname',
			maxLength : 20,
			msgTarget : 'under',
			allowBlank : false
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
			msgTarget : 'under',
			typeAhead : true
		}, {
			xtype : 'datefield',
			fieldLabel : '出生日期',
			name : 'user.birthday',
			id : 'birthday',
			allowBlank : false,
			format : 'Y.m.d',
			fieldLabel : '出生日期',
			msgTarget : 'under',
			maxValue : new Date()
		}, {
			xtype : 'textfield',
			fieldLabel : '身份证号',
			name : 'user.idNo',
			id : 'idNo',
			colspan : 2,
			width : 470,
			allowBlank : false,
			maxLength : 18,
			msgTarget : 'under',
			minLength : 18
		}, {
			xtype : 'combobox',
			fieldLabel : '学历',
			name : 'user.education.id',
			id : 'education.id',
			allowBlank : false,
			defaultListConfig : {
				loadMask : false
			},
			emptyText : '请选择',
			queryMode : 'local',//本地选择模式
			store : Ext.data.StoreManager.lookup('EducationStore'),
			valueField : 'id',
			displayField : 'name',
			forceSelection : true,
			msgTarget : 'under',
			typeAhead : true
		}, {
			xtype : 'textfield',
			fieldLabel : '毕业院校',
			name : 'user.school',
			id : 'school',
			colspan : 2,
			width : 470,
			msgTarget : 'under',
			allowBlank : false
		}, {
			xtype : 'datefield',
			fieldLabel : '毕业时间',
			format : 'Y.m.d',
			name : 'user.graduateTime',
			id : 'graduateTime',
			maxValue : new Date(),
			msgTarget : 'under',
			allowBlank : false
		}, {
			xtype : 'textfield',
			fieldLabel : '所学专业',
			name : 'user.major.name',
			id : 'major.id',
			allowBlank : false,
			msgTarget : 'under',
			readOnly : true,
			listeners : {
				render : function(p){
					p.getEl().on('click', function(p){
						subjectWindow.show();
					});
				}
			}
		}, {
			xtype : 'combobox',
			fieldLabel : '学位',
			name : 'user.degree.id',
			id : 'degree.id',
			allowBlank : false,
			msgTarget : 'under',
			defaultListConfig : {
				loadMask : false
			},
			emptyText : '请选择',
			queryMode : 'local',//本地选择模式
			store : Ext.data.StoreManager.lookup('DegreeStore'),
			valueField : 'id',
			displayField : 'name',
			forceSelection : true,
			typeAhead : true,
		}, {
			xtype : 'combobox',
			fieldLabel : '所属学会/协会',
			name : 'user.institution.id',
			id : 'institution.id',
			defaultListConfig : {
				loadMask : false
			},
			allowBlank : false,
			msgTarget : 'under',
			emptyText : '请选择',
			queryMode : 'local',
			store : Ext.data.StoreManager.lookup('InstitutionStore'),
			valueField : 'id',
			displayField : 'name',
			forceSelection : true,
			typeAhead : true
		}, {
			xtype : 'button',
			text : '上传',
			style : 'margin-left:25px;',
			colspan : 4,
			iconCls : 'upload',
			disabled : false,
			handler : function(){
				imgUploadWindow.show();
			}
		}, {
			xtype : 'textfield',
			fieldLabel : '工作单位',
			name : 'user.workUnit',
			id : 'workUnit',
			colspan : 2,
			width : 340,
			msgTarget : 'under',
			allowBlank : false
		}, {
			xtype : 'textfield',
			fieldLabel : '专业技术职称',
			name : 'user.title',
			id : 'title'
		}, {
			xtype : 'textfield',
			fieldLabel : '职务',
			name : 'user.duty',
			id : 'duty'
		}, {
			xtype : 'textfield',
			fieldLabel : '通讯地址',
			name : 'user.address',
			id : 'address',
			style : 'margin-top:10px;',
			width : 340,
			colspan : 2
		}, {
			xtype : 'textfield',
			fieldLabel : '手机',
			name : 'user.telephone',
			id : 'telephone',
			style : 'margin-top:10px;',
			allowBlank : false,
			maxLength : 11,
			msgTarget : 'under',
			regex : /^[1][3-8]+\d{9}/,
			regexText : '请输入正确的手机号'
		}, {
			xtype : 'textfield',
			fieldLabel : '办公电话',
			name : 'user.officePhone',
			id : 'officePhone',
			style : 'margin-top:10px;'
		}, {
			xtype : 'textfield',
			fieldLabel : '电子邮箱',
			name : 'user.email',
			id : 'email',
			style : 'margin-top:10px;',
			colspan : 2,
			width : 340,
			allowBlank : false,
			msgTarget : 'under',
			regex : /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/,
			regexText : '邮箱格式为XXX@XXX.com'
		}, {
			xtype : 'textfield',
			fieldLabel : '邮编',
			name : 'user.postcode',
			id : 'postcode',
			style : 'margin-top:10px;',
			maxLength : 6,
			minLength : 6
		}, {
			xtype : 'textfield',
			fieldLabel : 'QQ号',
			name : 'user.qq',
			id : 'qq',
			style : 'margin-top:10px;',
			maxLength : 12,
			minLength : 6
		}, {
			xtype : 'textarea',
			fieldLabel : '现从事专业',
			name : 'user.currentMajor',
			id : 'currentMajor',
			style : 'margin-top:10px;',
			allowBlank : false,
			msgTarget : 'under',
			width : 340,
			autoScroll : true,
			colspan : 2
		}, {
			xtype : 'textarea',
			fieldLabel : '擅长领域',
			name : 'user.adept',
			id : 'adept',
			style : 'margin-top:10px;',
			width : 480,
			colspan : 2
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
	/**
	 * 账户修改界面
	 */
	var modifyCountFP = Ext.create("Ext.form.Panel", {
		title : '修改账户',
		frame : true,
		//height : 200,
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
			msgTarget : 'under',
			allowBlank : false
		}, {
			xtype : 'textfield',
			fieldLabel : '原密码',
			name : 'userDTO.password',
			inputType : 'password',
			msgTarget : 'under',
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
			msgTarget : 'under'
		}, {
			xtype : 'textfield',
			fieldLabel : '确认密码',
			name : 'userDTO.confirmpass',
			maxLength : 20,
			inputType : 'password',
			regex : /^[\w]{6,}$/,
			regexText : '密码只能包含数字、字母、下划线，长度不少于6位',
			msgTarget : 'under',
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
	 * 添加论文窗口
	 */
	var addThesisWindow = Ext.create("Ext.window.Window", {
		title : '添加论文',
		plain : true,
		modal : true,
		layout : 'fit',
		closeAction : 'hide',
		resizable : false,
		items : [{
			xtype : 'form',
			frame : true,
			//height : 100,
			width : 350,
			buttonAlign : 'center',
			defaults : {
				labelSeparator : ' : ',
				labelAlign : 'right',
				labelWidth : 85
			},
			items : [{
				xtype : 'textfield',
				fieldLabel : '论文名称<br/>(核心期刊)',
				name : 'thesis.name',
				width : 300,
				msgTarget : 'under',
				allowBlank : false
			}, {
				xtype : 'textfield',
				fieldLabel : '收录年份',
				name : 'thesis.pubTime',
				msgTarget : 'under',
				allowBlank : false
			}],
			buttons : [{
				text : '保存',
				iconCls : 'save',
				disables : false,
				handler : function(){
					addThesis(addThesisWindow, addThesisWindow.down('form'), Ext.data.StoreManager.lookup('ThesisStore'), userId);
				}
			}]
		}]
	});
	/**
	 * 论文管理界面
	 */
	var thesisesGP = Ext.create("Ext.grid.Panel", { 
		title : '论文管理',
		width : 900,
		height : 500,
		style : 'margin-left:10%;margin-top:2%;',
		columns : [
		    {xtype : 'rownumberer'},
		    {text:'论文名称', dataIndex:'name', width : 650},
			{text:'收录日期', dataIndex:'pubTime', width :80},
			{header:'操作', xtype : 'actioncolumn', width : 60,
				items : [{
					icon : 'img/delete.ico',
					tooltip : '删除',
					handler : function(grid, row, col){
						deleteThesis(grid, row, col);
					}
				}]
			}
		],
		tbar : [
		    {xtype : 'button', text : '添加', iconCls:'add', style:'margin-left:40px;', handler: function(btn){addThesisWindow.show();}},
			{xtype : 'button', text : '删除', iconCls:'delete', style:'margin-left:20px;', handler: function(btn){deleteThesises(btn.ownerCt.ownerCt);}}
		],
		store : Ext.data.StoreManager.lookup('ThesisStore'),
		selType : 'checkboxmodel',
		multiSelect : true,
		dockedItems : [{
			xtype : 'pagingtoolbar',
			store : Ext.data.StoreManager.lookup('ThesisStore'),
			dock : 'bottom',
			displayInfo : true
		}],
		frame : true,
		loadMask : true
	});
	
	/**
	 * 添加专利窗口
	 */
	var addPatentWindow = Ext.create("Ext.window.Window", {
		title : '添加专利',
		plain : true,
		modal : true,
		layout : 'fit',
		closeAction : 'hide',
		resizable : false,
		items : [{
			xtype : 'form',
			frame : true,
			//height : 150,
			width : 350,
			buttonAlign : 'center',
			defaults : {
				labelSeparator : ' : ',
				labelAlign : 'right',
				labelWidth : 85,
			},
			items : [{
				xtype : 'textfield',
				fieldLabel : '专利名称',
				name : 'patent.name',
				width : 300,
				msgTarget : 'under',
				allowBlank : false
			}, {
				xtype : 'textfield',
				fieldLabel : '授权时间',
				name : 'patent.authorityTime',
				msgTarget : 'under',
				allowBlank : false
			}, {
				xtype : 'textfield',
				fieldLabel : '专利号',
				name : 'patent.patentNo',
				msgTarget : 'under',
				allowBlank : false
			}],
			buttons : [{
				text : '保存',
				iconCls : 'save',
				disables : false,
				handler : function(){
					addPatent(addPatentWindow, addPatentWindow.down('form'), Ext.data.StoreManager.lookup('PatentStore'), userId);
				}
			}]
		}]
	});
	/**
	 * 专利显示面板
	 */
	var patentsGP = Ext.create("Ext.grid.Panel", {
		title : '专利管理',
		width : 900,
		height : 500,
		style : 'margin-left:10%;margin-top:2%;',
		columns : [
		    {xtype : 'rownumberer'},
		    {text:'专利名称', dataIndex:'name', width : 550},
			{text:'授权日期', dataIndex:'authorityTime', width :70},
			{text:'专利号', dataIndex:'patentNo', width : 150},
			{header:'操作', xtype : 'actioncolumn', width : 40,
				items : [{
					icon : 'img/delete.ico',
					tooltip : '删除',
					handler : function(grid, row, col){
						deletePatent(grid, row, col);
					}
				}]
			}
		],
		tbar : [
		    {xtype : 'button', text : '添加', iconCls:'add', style:'margin-left:40px;', handler: function(btn){addPatentWindow.show();}},
			{xtype : 'button', text : '删除', iconCls:'delete', style:'margin-left:20px;', handler: function(btn){deletePatents(btn.ownerCt.ownerCt);}}
		],
		store : Ext.data.StoreManager.lookup('PatentStore'),
		selType : 'checkboxmodel',
		multiSelect : true,
		dockedItems : [{
			xtype : 'pagingtoolbar',
			store : Ext.data.StoreManager.lookup('PatentStore'),
			dock : 'bottom',
			displayInfo : true
		}],
		frame : true,
		loadMask : true
	});
	/**
	 * 添加项目窗口
	 */
	var addProjectWindow = Ext.create("Ext.window.Window", {
		title : '添加项目',
		plain : true,
		modal : true,
		layout : 'fit',
		closeAction : 'hide',
		resizable : false,
		items : [{
			xtype : 'form',
			frame : true,
			//height : 200,
			width : 550,
			buttonAlign : 'center',
			defaults : {
				labelSeparator : ' : ',
				labelAlign : 'right',
				labelWidth : 90
			},
			layout : {
				type : 'table',
				columns : 2
			},
			items : [{
				xtype : 'textfield',
				fieldLabel : '项目名称',
				name : 'project.name',
				colspan : 2,
				width : 480,
				msgTarget : 'under',
				allowBlank : false
			}, {
				xtype : 'textfield',
				fieldLabel : '委托单位',
				name : 'project.delegationUnit',
			}, {
				xtype : 'textfield',
				fieldLabel : '项目时间',
				name : 'project.projectTime',
				msgTarget : 'under',
				allowBlank : false
			}, {
				xtype : 'numberfield',
				fieldLabel : '项目拨款(万元)',
				name : 'project.allocation',
				minValue : 0,
				decimalPrecision : 2,
				allowDecimals : true,
				allowNegative :false
			}, {
				xtype : 'numberfield',
				fieldLabel : '自筹款项(万元)',
				name : 'project.selffinance',
				minValue : 0,
				decimalPrecision : 2,
				allowDecimals : true,
				allowNegative :false
			}, {
				xtype : 'combobox',
				fieldLabel : '项目级别',
				name : 'project.projectLevel',
				allowBlank : false,
				msgTarget : 'under',
				emptyText : '请选择',
				queryMode : 'local',
				store : Ext.data.StoreManager.lookup('LevelStore'),
				valueField : 'id',
				displayField : 'name',
				forceSelection : true,
				typeAhead : true
			}, {
				xtype : 'combobox',
				fieldLabel : '完成进展',
				name : 'project.completeStatus',
				allowBlank : false,
				emptyText : '请选择',
				queryMode : 'local',
				store : Ext.data.StoreManager.lookup('StatusStore'),
				valueField : 'id',
				displayField : 'name',
				forceSelection : true,
				msgTarget : 'under',
				typeAhead : true
			}, {
				xtype : 'textfield',
				fieldLabel : '本人作用',
				name : 'project.selfFunc',
				msgTarget : 'under',
				allowBlank : false
			}],
			buttons : [{
				text : '保存',
				iconCls : 'save',
				disables : false,
				handler : function(){
					addProject(addProjectWindow, addProjectWindow.down('form'), Ext.data.StoreManager.lookup('ProjectStore'), userId);
				}
			}]
		}]
	});
	/**
	 * 项目显示面板
	 */
	var projectsGP = Ext.create("Ext.grid.Panel", {
		title : '项目管理',
		width : 1000,
		height : 500,
		style : 'margin-left:7%;margin-top:2%;',
		columns : [
		    {xtype : 'rownumberer'},
		    {text:'项目名称', dataIndex:'name', width : 350},
			{text:'项目时间', dataIndex:'projectTime', width :100},
			{text:'本人作用', dataIndex:'selfFunc', width : 60},
			{text:'委托单位', dataIndex:'delegationUnit', width : 150},
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
			{text:'自筹', dataIndex:'selffinance', width : 40},
			{header:'操作', xtype : 'actioncolumn', width : 40,
				items : [{
					icon : 'img/delete.ico',
					tooltip : '删除',
					handler : function(grid, row, col){
						deleteProject(grid, row, col);
					}
				}]
			}
		],
		tbar : [
		    {xtype : 'button', text : '添加', iconCls:'add', style:'margin-left:40px;', handler: function(btn){addProjectWindow.show();}},
			{xtype : 'button', text : '删除', iconCls:'delete', style:'margin-left:20px;', handler: function(btn){deleteProjects(btn.ownerCt.ownerCt);}}
		],
		store : Ext.data.StoreManager.lookup('ProjectStore'),
		selType : 'checkboxmodel',
		multiSelect : true,
		dockedItems : [{
			xtype : 'pagingtoolbar',
			store : Ext.data.StoreManager.lookup('ProjectStore'),
			dock : 'bottom',
			displayInfo : true
		}],
		frame : true,
		loadMask : true
	});
	/**
	 * 添加奖励窗口
	 */
	var addAwardWindow = Ext.create("Ext.window.Window", {
		title : '添加奖励',
		plain : true,
		modal : true,
		layout : 'fit',
		closeAction : 'hide',
		resizable : false,
		items : [{
			xtype : 'form',
			frame : true,
			//height : 100,
			width : 500,
			buttonAlign : 'center',
			defaults : {
				labelSeparator : ' : ',
				labelAlign : 'right',
				labelWidth : 85
			},
			layout : {
				type : 'table',
				columns : 2
			},
			items : [{
				xtype : 'textfield',
				fieldLabel : '奖励名称',
				name : 'award.name',
				msgTarget : 'under',
				allowBlank : false
			}, {
				xtype : 'numberfield',
				fieldLabel : '排名',
				name : 'award.rank',
				minValue : 0,
				emptyText : 0
			}, {
				xtype : 'textfield',
				fieldLabel : '成果名称',
				name : 'award.fruitName',
				msgTarget : 'under',
				allowBlank : false
			}, {
				xtype : 'textfield',
				fieldLabel : '获奖时间',
				name : 'award.awardTime',
				msgTarget : 'under',
				allowBlank : false
			}],
			buttons : [{
				text : '保存',
				iconCls : 'save',
				disables : false,
				handler : function(){
					addAward(addAwardWindow ,addAwardWindow.down('form'), Ext.data.StoreManager.lookup('AwardStore'), userId);
				}
			}]
		}]
	});
	/**
	 * 显示奖励面板
	 */
	var awardsGP = Ext.create("Ext.grid.Panel", {
		title : '奖励',
		width : 900,
		height : 500,
		style : 'margin-left:10%;margin-top:2%;',
		columns : [
		    {xtype : 'rownumberer'},
		    {text:'奖励名称', dataIndex:'name', width : 330},
			{text:'成果名称', dataIndex:'fruitName', width :330},
			{text:'获奖时间', dataIndex:'awardTime', width : 70},
			{text:'排名', dataIndex:'rank', width : 60},
			{header:'操作', xtype : 'actioncolumn', width : 40,
				items : [{
					icon : 'img/delete.ico',
					tooltip : '删除',
					handler : function(grid, row, col){
						deleteAward(grid, row, col);
					}
				}]
			}
		],
		tbar : [
		    {xtype : 'button', text : '添加', iconCls:'add', style:'margin-left:40px;', handler: function(btn){addAwardWindow.show();}},
			{xtype : 'button', text : '删除', iconCls:'delete', style:'margin-left:20px;', handler: function(btn){deleteAwards(btn.ownerCt.ownerCt);}}
		],
		store : Ext.data.StoreManager.lookup('AwardStore'),
		selType : 'checkboxmodel',
		multiSelect : true,
		dockedItems : [{
			xtype : 'pagingtoolbar',
			store : Ext.data.StoreManager.lookup('ProjectStore'),
			dock : 'bottom',
			displayInfo : true
		}],
		frame : true,
		loadMask : true
	});
	
	//为树形菜单增加单击时间，根据id判断要添加的面板
	memberMenu.on({
		'itemclick' : function(view, record, item, index, event, options){
			if(record.get('leaf')){
				showMe(record, mainPanel, showUser);
				showCount(record, mainPanel, modifyCountFP);
				showThesises(record, mainPanel, thesisesGP, Ext.data.StoreManager.lookup('ThesisStore'));
				showPatents(record, mainPanel, patentsGP, Ext.data.StoreManager.lookup('PatentStore'));
				showProjects(record, mainPanel, projectsGP, Ext.data.StoreManager.lookup('ProjectStore'));
				showAwards(record, mainPanel, awardsGP, Ext.data.StoreManager.lookup('AwardStore'));
				//消除HTML div上的内容
				var mainDiv = Ext.getDom('main');
				mainDiv.innerHTML = '';
			}
		}
	});
});