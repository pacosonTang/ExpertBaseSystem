//用户界面
Ext.onReady(function(){
	Ext.QuickTips.init();
	
	//定义全局变量,用以存储当前操作的用户
	var userId = '';
	var flag=1;
	
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
			items : managerMenu,
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
					var combo = subjectWindow.down('form').form.findField('thirdSubject');
					var record;
				    combo.getStore().each(function(r){
				        if(r.get('id') == combo.getValue()){
				            record = r;
				            return false;
				        }
				    });
				    if(flag == 1)
				    	addMemberWindow.down('form').form.findField('user.major.id').setValue(combo.getValue() + '-' + record.get('name'));
				    else
				    	modifyMemberWindow.down('form').form.findField('user.major.id').setValue(combo.getValue() + '-' + record.get('name'));
					subjectWindow.hide();
				}
			}]
		}]
	});
	/**
	 * 图片上传
	 */
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
			height : 60,
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
				regex : /\.(jpg|gif|bmp|png|JPG|GIF|BMP|PNG)/,
				regexText : '图片格式只能为.jpg/.gif/.bmp/.png',
				msgTarget : 'side'
			}],
			buttons : [{
				text : '上传',
				iconCls : 'save',
				disabled : false,
				handler : function(){
					if(flag == 1)
						savaImg(imgUploadWindow.down('form'), addMemberWindow.down('form'));
					else
						savaImg(imgUploadWindow.down('form'), modifyMemberWindow.down('form'));
				}
			}]
		}]
	});
	/**
	 * 修改会员
	 */
	var modifyMemberWindow = Ext.create("Ext.window.Window", {
		title : '添加用户',
		plain : true,
		layout : 'fit',
		closeAction : 'hide',
		resizable : false,
		modal : true,
		items : [{
			xtype : 'form',
			frame : true,
			height : 400,
			width : 850,
			buttonAlign : 'center',
			defaults : {
				labelSeparator : ' : ',
				labelAlign : 'right',
				labelWidth : 85
			},
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
				id : 'education.id',
				allowBlank : false,
				emptyText : '请选择',
				queryMode : 'remote',
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
				xtype : 'textfield',
				fieldLabel : '所学专业',
				name : 'user.major.name',
				id : 'user.major.id',
				allowBlank : false,
				readOnly : true,
				listeners : {
					render : function(p){
						p.getEl().on('click', function(p){
							flag=0;
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
				emptyText : '请选择',
				queryMode : 'remote',
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
				editale : false,
				allowBlank : false,
				emptyText : '请选择',
				queryMode : 'remote',
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
					flag=0;
					imgUploadWindow.show();
				}
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
			}, {
				xtype : 'textfield',
				fieldLabel : '电子邮箱',
				name : 'user.email',
				id : 'email',
				style : 'margin-top:10px;',
				colspan : 2,
				width : 340,
				regex : /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/,
				regexText : '邮箱格式为XXX@XXX.com',
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
				maxLength : 10,
				minLength : 6
			}, {
				xtype : 'textarea',
				fieldLabel : '现从事专业',
				name : 'user.currentMajor',
				id : 'user.currentMajor',
				allowBlank : false,
				colspan : 2,
				autoScroll : true,
				style : 'margin-top:10px;',
				width : 340
			}, {
				xtype : 'textarea',
				fieldLabel : '擅长领域',
				name : 'user.adept',
				id : 'adept',
				style : 'margin-top:10px;',
				width : 480,
				autoScroll : true,
				colspan : 2
			}, {
				xtype : 'textfield',
				hidden : true,
				name : 'user.avatar',
			}, {
				xtype : 'textfield',
				hidden : true,
				name : 'user.id',
			}, {
				xtype : 'textfield',
				hidden : true,
				name : 'user.username',
			}, {
				xtype : 'textfield',
				hidden : true,
				name : 'user.password',
			}],
			buttons : [{
				text : '保存',
				iconCls : 'save',
				disabled : false,
				handler : function(){
					modifyMember(modifyMemberWindow.down('form'), Ext.data.StoreManager.lookup('UserStore'));
				}
			}]
		}]
	});
	/**
	 * 添加会员
	 */
	var addMemberWindow = Ext.create("Ext.window.Window", {
		title : '添加用户',
		plain : true,
		layout : 'fit',
		closeAction : 'hide',
		resizable : false,
		modal : true,
		items : [{
			xtype : 'form',
			frame : true,
			height : 400,
			width : 850,
			buttonAlign : 'center',
			defaults : {
				labelSeparator : ' : ',
				labelAlign : 'right',
				labelWidth : 85
			},
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
				id : 'education.id',
				allowBlank : false,
				emptyText : '请选择',
				queryMode : 'remote',
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
				xtype : 'textfield',
				fieldLabel : '所学专业',
				name : 'user.major.name',
				id : 'user.major.id',
				allowBlank : false,
				readOnly : true,
				listeners : {
					render : function(p){
						p.getEl().on('click', function(p){
							flag=1;
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
				emptyText : '请选择',
				queryMode : 'remote',
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
				editale : false,
				allowBlank : false,
				emptyText : '请选择',
				queryMode : 'remote',
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
					flag=1;
					imgUploadWindow.show();
				}
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
			}, {
				xtype : 'textfield',
				fieldLabel : '电子邮箱',
				name : 'user.email',
				id : 'email',
				style : 'margin-top:10px;',
				colspan : 2,
				width : 340,
				regex : /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/,
				regexText : '邮箱格式为XXX@XXX.com',
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
				maxLength : 10,
				minLength : 6
			}, {
				xtype : 'textarea',
				fieldLabel : '现从事专业',
				name : 'user.currentMajor',
				id : 'user.currentMajor',
				allowBlank : false,
				colspan : 2,
				autoScroll : true,
				style : 'margin-top:10px;',
				width : 340
			}, {
				xtype : 'textarea',
				fieldLabel : '擅长领域',
				name : 'user.adept',
				id : 'adept',
				style : 'margin-top:10px;',
				width : 480,
				autoScroll : true,
				colspan : 2
			}, {
				xtype : 'textfield',
				hidden : true,
				name : 'user.avatar',
			}],
			buttons : [{
				text : '保存',
				iconCls : 'save',
				disabled : false,
				handler : function(){
					addMember(addMemberWindow.down('form'), Ext.data.StoreManager.lookup('UserStore'));
				}
			}, {
				text : '重置',
				iconCls : 'cancel',
				disables : false,
				handler : function(){
					addMemberWindow.down('form').form.reset();
				}
			}]
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
			height : 100,
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
				allowBlank : false
			}, {
				xtype : 'textfield',
				fieldLabel : '收录年份',
				name : 'thesis.pubTime',
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
			height : 150,
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
				allowBlank : false
			}, {
				xtype : 'textfield',
				fieldLabel : '授权时间',
				name : 'patent.authorityTime',
				allowBlank : false
			}, {
				xtype : 'textfield',
				fieldLabel : '专利号',
				name : 'patent.patentNo',
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
			height : 200,
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
				allowBlank : false
			}, {
				xtype : 'textfield',
				fieldLabel : '委托单位',
				name : 'project.delegationUnit',
			}, {
				xtype : 'textfield',
				fieldLabel : '项目时间',
				name : 'project.projectTime',
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
				typeAhead : true
			}, {
				xtype : 'textfield',
				fieldLabel : '本人作用',
				name : 'project.selfFunc',
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
			height : 100,
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
				allowBlank : false
			}, {
				xtype : 'textfield',
				fieldLabel : '获奖时间',
				name : 'award.awardTime',
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
	 * 显示会员的成就
	 */
	var showAchieves = Ext.create("Ext.window.Window", {
		title : '成就',
		plain : true,
		modal : true,
		height : 520,
		layout : 'fit',
		closeAction : 'hide',
		resizable : false,
		items : [{
			xtype : 'tabpanel',
			width : 700,
			heigth : 500,
			activeTab : 0,
			items : [{
				title : '论文',
				xtype : 'gridpanel',
				columns : [
				    {xtype : 'rownumberer'},
				    {text:'论文名称', dataIndex:'name', width : 550},
					{text:'收录日期', dataIndex:'pubTime', width :80},
					{header:'操作', xtype : 'actioncolumn', width : 40,
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
				frame : true,
				loadMask : true
			}, {
				title : '专利',
				xtype : 'gridpanel',
				columns : [
				    {xtype : 'rownumberer'},
				    {text:'专利名称', dataIndex:'name', width : 350},
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
				frame : true,
				loadMask : true
			}, {
				title : '项目',
				xtype : 'gridpanel',
				columns : [
				    {xtype : 'rownumberer'},
				    {text:'项目名称', dataIndex:'name', width : 130},
					{text:'项目时间', dataIndex:'projectTime', width :70},
					{text:'本人作用', dataIndex:'selfFunc', width : 60},
					{text:'委托单位', dataIndex:'delegationUnit', width : 110},
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
					{text:'项目状态', dataIndex:'completeStatus', width : 60, 
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
				frame : true,
				loadMask : true
			}, {
				title : '奖励',
				xtype : 'gridpanel',
				columns : [
				    {xtype : 'rownumberer'},
				    {text:'奖励名称', dataIndex:'name', width : 200},
					{text:'成果名称', dataIndex:'fruitName', width :200},
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
				frame : true,
				loadMask : true
			}]
		}]
	});
	
	//为tabpanel添加切换事件
	showAchieves.down('tabpanel').on('tabchange', function(tabPanel, newCard, oldCard){
		if(newCard.title == '论文')
			Ext.data.StoreManager.lookup('ThesisStore').load({
				params : {
					userId : userId
				}
			});
		else if(newCard.title == '专利')
			Ext.data.StoreManager.lookup('PatentStore').load({
				params : {
					userId : userId
				}
			});
		else if(newCard.title == '项目')
			Ext.data.StoreManager.lookup('ProjectStore').load({
				params : {
					userId : userId
				}
			});
		else if(newCard.title == '奖励')
			Ext.data.StoreManager.lookup('AwardStore').load({
				params : {
					userId : userId
				}
			});
	});
	/**
	 * 会员搜索面板以及用户管理面板的集成
	 */
	var membersPanel = Ext.create("Ext.panel.Panel", {
		title : '会员查询',
		layout : 'fit',
		style : 'margin:5px 2% 0;',
		width : 1120,
		heigth : 540,
		frame : true,
		items : [{
			xtype : 'form',
			width : 1100,
			height : 60,
			frame : true,
			layout : {
				type : 'table',
				columns : 4
			},
			buttonAlign : 'center',
			defaults : {
				labelSeparator : ' : ',
				labelAlign : 'right',
				labelWidth : 80
			},
			items : [{
				xtype : 'combobox',
				fieldLabel : '学位',
				style : 'margin-left:80px;',
				name : 'conditionDTO.degree',
				emptyText : '请选择',
				queryMode : 'remote',
				store : Ext.data.StoreManager.lookup('DegreeStore'),
				valueField : 'id',
				displayField : 'name',
				forceSelection : true,
				typeAhead : true,
			}, {
				xtype : 'combobox',
				fieldLabel : '学历',
				name : 'conditionDTO.education',
				emptyText : '请选择',
				queryMode : 'remote',
				store : Ext.data.StoreManager.lookup('EducationStore'),
				valueField : 'id',
				displayField : 'name',
				forceSelection : true,
				typeAhead : true,
			}, {
				xtype : 'combobox',
				fieldLabel : '协会',
				name : 'conditionDTO.institution',
				emptyText : '请选择',
				queryMode : 'remote',
				store : Ext.data.StoreManager.lookup('InstitutionStore'),
				valueField : 'id',
				displayField : 'name',
				forceSelection : true,
				typeAhead : true,
			}, {
				xtype : 'textfield',
				fieldLabel : '专业技术职称',
				name : 'conditionDTO.title'
			}, {
				xtype : 'textfield',
				fieldLabel : '现从事专业',
				style : 'margin-left:80px;',
				name : 'conditionDTO.currentMajor'
			}, {
				xtype : 'textfield',
				fieldLabel : '擅长领域',
				name : 'conditionDTO.adept',
			}, {
				xtype : 'button',
				text : '搜索',
				iconCls : 'search',
				disabled : false,
				style : 'margin-left:50px;',
				handler : function(btn){
					searchMember(btn.ownerCt.ownerCt);
				}
			}]
		}, {
			xtype : 'gridpanel',
			width : 1110,
			height : 450,
			columns : [
				{xtype : 'rownumberer'},
				{text:'姓名', dataIndex:'realname', width : 60},
				{text:'性别', dataIndex:'sex', width : 40},
				{text:'专业技术职称', dataIndex:'title', width : 80},
				{text:'毕业院校', dataIndex:'school', width : 80},
				{text:'学历', dataIndex:'education.name', width : 40},
				{text:'学位', dataIndex:'degree.name', width : 40},
				{text:'所学专业', dataIndex:'major.name', width : 80},
				{text:'邮箱', dataIndex:'email', width : 120},
				{text:'手机', dataIndex:'telephone', width : 80},
				{text:'办公电话', dataIndex:'officePhone', width : 80},
				{text:'通讯地址', dataIndex:'address', width : 160},
				{text:'工作单位', dataIndex:'workUnit', width : 120},
				{header : "操作", xtype : 'actioncolumn', width : 60,
					items : [{
						icon : 'img/look.ico',
						tooltip : '查看',
						handler : function(grid, row, col){
							showMember(grid, row, modifyMemberWindow);
						}
					}, {
						icon : 'img/delete.ico',
						tooltip : '删除',
						handler : function(grid, row, col){
							deleteMember(grid, row, col);
						}
					}, {
						icon : 'img/add-achieve.ico',
						tooltip : '成就',
						handler : function(grid, row, col){
							userId = grid.getStore().getAt(row).get('id');
							showAchieves.down('tabpanel').setActiveTab(0);
							showAchieves.show();
							Ext.data.StoreManager.lookup('ThesisStore').load({
								params : {
									userId : userId
								}
							});
						}
					}]
				}
			],
			tbar : [
			    {xtype : 'button', text : '添加', iconCls:'add', style:'margin-left:40px;', handler: function(btn){addMemberWindow.show();}},
				{xtype : 'button', text : '删除', iconCls:'delete', style:'margin-left:20px;', handler: function(btn){deleteMembers(btn.ownerCt.ownerCt);}}
			],
			store : Ext.data.StoreManager.lookup('UserStore'),
			selType : 'checkboxmodel',
			multiSelect : true,
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
	//领导添加窗口
	var addLeaderWindow = Ext.create("Ext.window.Window", {
		title : '添加领导',
		plain : true,
		layout : 'fit',
		closeAction : 'hide',
		resizable : false,
		modal : true,
		items : [{
			xtype : 'form',
			frame : true,
			height : 200,
			width : 700,
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
				handler : function(){
					addLeader(addLeaderWindow.down('form'), Ext.data.StoreManager.lookup('LeaderStore'));
				}
			}, {
				text : '重置',
				iconCls : 'cancel',
				disables : false,
				handler : function(){
					addLeaderWindow.down('form').form.reset();
				}
			}]
		}]
	});
	var leadersGP = Ext.create("Ext.grid.Panel", {
		title : '领导管理',
		width : 1100,
		height : 530,
		style : 'margin:10px 2% 0;',
		columns : [
			{xtype : 'rownumberer'},
			{text:'用户名', dataIndex:'username', width :100},
			{text:'姓名', dataIndex:'realname', width : 80},
			{text:'性别', dataIndex:'sex', width : 40},
			{text:'手机', dataIndex:'telephone', width : 80},
			{text:'办公电话', dataIndex:'officePhone', width : 80},
			{text:'邮编', dataIndex:'postcode', width : 80},
			{text:'邮箱', dataIndex:'email', width : 120},
			{text:'通讯地址', dataIndex:'address', width : 170},
			{text:'工作单位', dataIndex:'workUnit', width : 150},
			{text:'职务', dataIndex:'duty', width : 100},
			{header : "操作", xtype : 'actioncolumn', width : 40,
				items : [{
					icon : 'img/delete.ico',
					tooltip : '删除',
					handler : function(grid, row, col){
						deleteLeader(grid, row, col);
					}
				}]
			}
		],
		tbar : [
		    {xtype : 'button', text : '添加', iconCls:'add', style:'margin-left:40px;', handler: function(btn){addLeaderWindow.show();}},
			{xtype : 'button', text : '删除', iconCls:'delete', style:'margin-left:20px;', handler: function(btn){deleteLeaders(btn.ownerCt.ownerCt);}}
		],
		store : Ext.data.StoreManager.lookup('LeaderStore'),
		selType : 'checkboxmodel',
		multiSelect : true,
		dockedItems : [{
			xtype : 'pagingtoolbar',
			store : Ext.data.StoreManager.lookup('LeaderStore'),
			dock : 'bottom',
			displayInfo : true
		}],
		frame : true,
		loadMask : true
	});
	
	var addServerWindow = Ext.create("Ext.window.Window", {
		title : '添加领导',
		plain : true,
		layout : 'fit',
		closeAction : 'hide',
		resizable : false,
		modal : true,
		items : [{
			xtype : 'form',
			frame : true,
			height : 200,
			width : 700,
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
				handler : function(){
					addServer(addServerWindow.down('form'), Ext.data.StoreManager.lookup('ServerStore'));
				}
			}, {
				text : '重置',
				iconCls : 'cancel',
				disables : false,
				handler : function(){
					addServerWindow.down('form').form.reset();
				}
			}]
		}]
	});
	
	var serversGP = Ext.create("Ext.grid.Panel", {
		title : '服务人员管理',
		width : 1100,
		height : 530,
		style : 'margin:10px 2% 0;',
		columns : [
			{xtype : 'rownumberer'},
			{text:'用户名', dataIndex:'username', width :100},
			{text:'姓名', dataIndex:'realname', width : 80},
			{text:'性别', dataIndex:'sex', width : 40},
			{text:'手机', dataIndex:'telephone', width : 80},
			{text:'办公电话', dataIndex:'officePhone', width : 80},
			{text:'邮编', dataIndex:'postcode', width : 80},
			{text:'邮箱', dataIndex:'email', width : 120},
			{text:'通讯地址', dataIndex:'address', width : 170},
			{text:'工作单位', dataIndex:'workUnit', width : 150},
			{text:'职务', dataIndex:'duty', width : 100},
			{header : "操作", xtype : 'actioncolumn', width : 40,
				items : [{
					icon : 'img/delete.ico',
					tooltip : '删除',
					handler : function(grid, row, col){
						deleteServer(grid, row, col);
					}
				}]
			}
		],
		tbar : [
		    {xtype : 'button', text : '添加', iconCls:'add', style:'margin-left:40px;', handler: function(btn){addServerWindow.show();}},
			{xtype : 'button', text : '删除', iconCls:'delete', style:'margin-left:20px;', handler: function(btn){deleteServers(btn.ownerCt.ownerCt);}}
		],
		store : Ext.data.StoreManager.lookup('ServerStore'),
		selType : 'checkboxmodel',
		multiSelect : true,
		dockedItems : [{
			xtype : 'pagingtoolbar',
			store : Ext.data.StoreManager.lookup('ServerStore'),
			dock : 'bottom',
			displayInfo : true
		}],
		frame : true,
		loadMask : true
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
	
	//显示用户信息的json读取器
	var leaderJsonReader = Ext.create('Ext.data.JsonReader', {
		root : 'list',
	    totalProperty : 'totalCount',
	    id : 'id',
	    successProperty : '@success',
	    model : 'Leader'
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
	
	//一级学科专业添加窗口
	var addFirstWindow = Ext.create("Ext.window.Window", {
		title : '添加一级学科',
		closeAction : 'hide',
		plain : true,
		layout : 'fit',
		modal : true,
		items : [{
			xtype : 'form',
			width : 220,
			heght : 50,
			frame : true,
			buttonAlign : 'center',
			defaults : {
				labelSeparator : ' : ',
				labelAlign : 'right',
				labelWidth : 40
			},
			items : [{
				xtype : 'textfield',
				fieldLabel : '名称',
				name : 'subject.name',
				allowBlank : false
			}],
			buttons : [{
				text : '保存',
				iconCls : 'save',
				disabled : false,
				handler : function(btn){
					addFirst(btn.ownerCt.ownerCt, Ext.data.StoreManager.lookup('SubjectStore'));
				}
			}]
		}]
	});
	
	//二级学科专业添加窗口
	var addSecondWindow = Ext.create("Ext.window.Window", {
		title : '添加二级学科',
		closeAction : 'hide',
		plain : true,
		layout : 'fit',
		modal : true,
		items : [{
			xtype : 'form',
			width : 230,
			heght : 100,
			frame : true,
			buttonAlign : 'center',
			defaults : {
				labelSeparator : ' : ',
				labelAlign : 'right',
				labelWidth : 60
			},
			items : [{
				xtype : 'combobox',
				fieldLabel : '一级学科',
				name : 'subject.parent.id',
				emptyText : '请选择',
				queryMode : 'remote',
				allowBlank : false,
				store : Ext.data.StoreManager.lookup('FirstMajorStore'),
				valueField : 'id',
				displayField : 'name',
				forceSelection : true,
				typeAhead : true
			}, {
				xtype : 'textfield',
				fieldLabel : '名称',
				name : 'subject.name',
				allowBlank : false
			}],
			buttons : [{
				text : '保存',
				iconCls : 'save',
				disabled : false,
				handler : function(btn){
					addSecond(btn.ownerCt.ownerCt, Ext.data.StoreManager.lookup('SubjectStore'));
				}
			}]
		}]
	});
	
	//一级学科专业添加窗口
	var addThirdWindow = Ext.create("Ext.window.Window", {
		title : '添加一级学科',
		closeAction : 'hide',
		plain : true,
		layout : 'fit',
		modal : true,
		items : [{
			xtype : 'form',
			width : 230,
			heght : 150,
			frame : true,
			buttonAlign : 'center',
			defaults : {
				labelSeparator : ' : ',
				labelAlign : 'right',
				labelWidth : 60
			},
			items : [{
				xtype : 'combobox',
				fieldLabel : '一级学科',
				emptyText : '请选择',
				queryMode : 'remote',
				allowBlank : false,
				store : Ext.data.StoreManager.lookup('FirstMajorStore'),
				valueField : 'id',
				displayField : 'name',
				forceSelection : true,
				typeAhead : true,
				listeners : {
					select : function(combo, record, opt){
						var comS = Ext.getCmp('second');
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
				name : 'subject.parent.id',
				id : 'second',
				readOnly : true,
				defaultListConfig : {
					loadMask : false
				},
				emptyText : '请选择',
				queryMode : 'local',
				allowBlank : false,
				store : Ext.data.StoreManager.lookup('SecondMajorStore'),
				valueField : 'id',
				displayField : 'name',
				forceSelection : true,
				typeAhead : true,
			}, {
				xtype : 'textfield',
				fieldLabel : '名称',
				name : 'subject.name',
				allowBlank : false
			}],
			buttons : [{
				text : '保存',
				iconCls : 'save',
				disabled : false,
				handler : function(btn){
					addThird(btn.ownerCt.ownerCt, Ext.data.StoreManager.lookup('SubjectStore'));
				}
			}]
		}]
	});
	
	//学科管理界面
	var subjectsGP = Ext.create("Ext.grid.Panel", {
		title : '学科专业管理',
		width : 580,
		height : 530,
		style : 'margin:10px 25% 0;',
		columns : [
			{xtype : 'rownumberer'},
			{text:'编号', dataIndex:'id', width :80},
			{text:'名称', dataIndex:'name', width : 150},
			{text:'父级学科编号', dataIndex:'parent.id', width : 80,
				renderer : function(value){
					if(value == 0){
						return '';
					}else{
						return value;
					}
				}
			},
			{text:'父级学科名称', dataIndex:'parent.name', width : 150},
			{header : "操作", xtype : 'actioncolumn', width : 40,
				items : [{
					icon : 'img/delete.ico',
					tooltip : '删除',
					handler : function(grid, row, col){
						deleteSubject(grid, row, col);
					}
				}]
			}
		],
		tbar : [
		    {xtype : 'button', text : '添加一级学科', iconCls:'add', style:'margin-left:10px;', handler: function(btn){addFirstWindow.show();}},
		    {xtype : 'button', text : '添加二级学科', iconCls:'add', style:'margin-left:20px;', handler: function(btn){addSecondWindow.show();}},
		    {xtype : 'button', text : '添加三级学科', iconCls:'add', style:'margin-left:20px;', handler: function(btn){addThirdWindow.show();}},
			{xtype : 'button', text : '删除', iconCls:'delete', style:'margin-left:20px;', handler: function(btn){deleteSubjects(btn.ownerCt.ownerCt);}}
		],
		store : Ext.data.StoreManager.lookup('SubjectStore'),
		selType : 'checkboxmodel',
		multiSelect : true,
		dockedItems : [{
			xtype : 'pagingtoolbar',
			store : Ext.data.StoreManager.lookup('SubjectStore'),
			dock : 'bottom',
			displayInfo : true
		}],
		frame : true,
		loadMask : true
	});
	
	//为树形菜单增加单击时间，根据id判断要添加的面板
	managerMenu.on({
		'itemclick' : function(view, record, item, index, event, options){
			if(record.get('leaf')){
				showMembers(record, mainPanel, membersPanel, Ext.data.StoreManager.lookup('UserStore'));
				showLeaders(record, mainPanel, leadersGP, Ext.data.StoreManager.lookup('LeaderStore'));
				showServers(record, mainPanel, serversGP, Ext.data.StoreManager.lookup('ServerStore'));
				showSubjects(record, mainPanel, subjectsGP, Ext.data.StoreManager.lookup('SubjectStore'));
				showCount(record, mainPanel, modifyCountFP);
				showMe(record, mainPanel, showUser);
				//消除HTML div上的内容
				var mainDiv = Ext.getDom('main');
				mainDiv.innerHTML = '';
			}
		}
	});
});