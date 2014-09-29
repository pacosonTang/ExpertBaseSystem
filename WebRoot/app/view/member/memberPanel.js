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
		height : 350,
		width : 850,
		reader : userJsonReader,
		buttonAlign : 'center',
		defaults : {
			labelSeparator : ' : ',
			labelAlign : 'right',
			labelWidth : 85,
		},
		layout : {
			type : 'table',
			columns : 4,
			cellCls : 'highlight'
		},
		items : [{
			xtype : 'image',
			name : 'user.avatar',
			id : 'avatar',
			width : 100,
			height : 134,
			rowspan : 4
		}, {
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
			xtype : 'datefield',
			fieldLabel : '出生日期',
			name : 'user.birthday',
			id : 'birthday',
			allowBlank : false,
			format : 'Y.m.d',
			fieldLabel : '出生日期',
			maxValue : new Date(),
		}, {
			xtype : 'textfield',
			fieldLabel : '身份证号',
			name : 'user.idNo',
			id : 'idNo',
			colspan : 2,
			width : 470,
			allowBlank : false,
			maxLength : 18,
			minLength : 18,
		}, {
			xtype : 'combobox',
			fieldLabel : '学历',
			name : 'user.education.id',
			id : 'education.name',
			allowBlank : false,
			emptyText : '请选择',
			queryMode : 'remote',//本地选择模式
			store : Ext.data.StoreManager.lookup('EducationStore'),
			valueField : 'id',
			displayField : 'name',
			forceSelection : true,
			typeAhead : true,
		}, {
			xtype : 'textfield',
			fieldLabel : '毕业院校',
			name : 'user.school',
			id : 'school',
			colspan : 2,
			width : 470,
			allowBlank : false
		}, {
			xtype : 'datefield',
			fieldLabel : '毕业时间',
			format : 'Y.m.d',
			name : 'user.graduateTime',
			id : 'graduateTime',
			maxValue : new Date(),
			allowBlank : false
		}, {
			xtype : 'combobox',
			fieldLabel : '所学专业',
			name : 'user.major.id',
			id : 'major.name',
			allowBlank : false,
			emptyText : '请选择',
			queryMode : 'remote',//本地选择模式
			store : Ext.data.StoreManager.lookup('MajorStore'),
			valueField : 'id',
			displayField : 'name',
			forceSelection : true,
			typeAhead : true,
		}, {
			xtype : 'combobox',
			fieldLabel : '学位',
			name : 'user.degree.id',
			id : 'degree.name',
			allowBlank : false,
			emptyText : '请选择',
			queryMode : 'remote',//本地选择模式
			store : Ext.data.StoreManager.lookup('DegreeStore'),
			valueField : 'id',
			displayField : 'name',
			forceSelection : true,
			typeAhead : true,
		}, {
			xtype : 'combobox',
			fieldLabel : '所属学会/协会',
			name : 'user.institution.id',
			id : 'institution.name',
			allowBlank : false,
			emptyText : '请选择',
			queryMode : 'remote',
			store : Ext.data.StoreManager.lookup('InstitutionStore'),
			valueField : 'id',
			displayField : 'name',
			forceSelection : true,
			typeAhead : true
		}, {
			xtype : 'textfield',
			fieldLabel : '工作单位',
			name : 'user.workUnit',
			id : 'workUnit',
			style : 'margin-top:10px;',
			colspan : 2,
			width : 340,
			allowBlank : false,
		}, {
			xtype : 'textfield',
			fieldLabel : '专业技术职称',
			name : 'user.title',
			id : 'title',
			style : 'margin-top:10px;',
		}, {
			xtype : 'textfield',
			fieldLabel : '职务',
			name : 'user.duty',
			id : 'duty',
			style : 'margin-top:10px;',
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
			regex : /^[1][3-8]+\d{9}/,
			regexText : '请输入正确的手机号',
		}, {
			xtype : 'textfield',
			fieldLabel : '办公电话',
			name : 'user.officePhone',
			id : 'officePhone',
			style : 'margin-top:10px;',
			emptyText : '例:028-12345678-01'
		}, {
			xtype : 'textfield',
			fieldLabel : '电子邮箱',
			name : 'user.email',
			id : 'email',
			style : 'margin-top:10px;',
			colspan : 2,
			width : 340,
			allowBlank : false,
			regex : /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/,
			regexText : '邮箱格式为XXX@XXX.com',
		}, {
			xtype : 'textfield',
			fieldLabel : '邮编',
			name : 'user.postcode',
			id : 'postcode',
			style : 'margin-top:10px;',
			regex : '/^[1-9][0-9]{5}$/',
			regexText : '请输入正确的邮编'
		}, {
			xtype : 'textfield',
			fieldLabel : 'QQ号',
			name : 'user.qq',
			id : 'qq',
			style : 'margin-top:10px;',
			maxLength : 10,
			minLength : 6
		}, {
			xtype : 'combobox',
			fieldLabel : '现从事专业',
			name : 'user.currentMajor.id',
			id : 'currentMajor.name',
			style : 'margin-top:10px;',
			allowBlank : false,
			emptyText : '请选择',
			queryMode : 'remote',
			store : Ext.data.StoreManager.lookup('MajorStore'),
			valueField : 'id',
			displayField : 'name',
			forceSelection : true,
			colspan : 2,
			typeAhead : true
		}, {
			xtype : 'textfield',
			fieldLabel : '擅长领域',
			name : 'user.adept',
			id : 'adept',
			style : 'margin-top:10px;',
			width : 480,
			colspan : 2,
			emptyText : '领域之间用英文","隔开'
		}],
		buttons : [{
			text : '保存',
			iconCls : 'save',
			disabled : false,
			handler : function(){
				
			}
		}]
	});

	//为树形菜单增加单击时间，根据id判断要添加的面板
	memberMenu.on({
		'itemclick' : function(view, record, item, index, event, options){
			if(record.get('leaf')){
				showUserForm(record, mainPanel, showUser);
//				showModifyUser(record, mainPanel, showUser);
//				showModifyPass(record, mainPanel, modifyPass);
//				showMyMessage(record, mainPanel, OldMessagePanel, Ext.data.StoreManager.lookup('userMessageStore'));
//				showUserAudit(record, mainPanel, RegisterUserPanel, Ext.data.StoreManager.lookup('RegisterUserStore'));
//				showTempBorrowAudit(record, mainPanel, TempBorrowPanel, Ext.data.StoreManager.lookup('adminTempBorrowStore'));
//				showTempPorAudit(record, mainPanel, TempPorPanel, Ext.data.StoreManager.lookup('adminTempPorStore'));
//				showBorrowRecordPanel(record, mainPanel, BorrowRecordPanel, Ext.data.StoreManager.lookup('adminPassBorrowStore'));
//				showPorRecordPanel(record, mainPanel, PorRecordPanel, Ext.data.StoreManager.lookup('adminPassPorStore'));
//				//消除HTML div上的内容
				var mainDiv = Ext.getDom('main');
				mainDiv.innerHTML = '';
			}
		}
	});
});