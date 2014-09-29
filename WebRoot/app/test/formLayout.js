Ext.onReady(function(){
	Ext.QuickTips.init();
	
	Ext.create('Ext.form.Panel', {
		title : '布局测试',
		renderTo : 'formtest',
		frame : true,
		height : 350,
		width : 850,
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
			name : 'avatar',
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
			name : 'userDetail.sex',
			id : 'userDetail.sex',
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
			name : 'userDetail.birthday',
			id : 'userDetail.birthday',
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
			name : 'userDetail.education.id',
			id : 'userDetail.education.name',
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
			name : 'userDetail.school',
			id : 'userDetail.school',
			colspan : 2,
			width : 470,
			allowBlank : false
		}, {
			xtype : 'datefield',
			fieldLabel : '毕业时间',
			format : 'Y.m.d',
			name : 'userDetail.graduateTime',
			id : 'userDetail.graduateTime',
			maxValue : new Date(),
			allowBlank : false
		}, {
			xtype : 'combobox',
			fieldLabel : '所学专业',
			name : 'userDetail.major.id',
			id : 'userDetail.major.name',
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
			name : 'userDetail.degree.id',
			id : 'userDetail.degree.name',
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
			name : 'userDetail.institution.id',
			id : 'userDetail.institution.id',
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
			name : 'userDetail.title',
			id : 'userDetail.title',
			style : 'margin-top:10px;',
		}, {
			xtype : 'textfield',
			fieldLabel : '职务',
			name : 'userDetail.duty',
			id : 'userDetail.duty',
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
			name : 'user.officephone',
			id : 'officephone',
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
			name : 'userDetail.currentMajor.id',
			id : 'userDetail.currentMajor.id',
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
			name : 'userDetail.adept',
			id : 'userDetail.adept',
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
});