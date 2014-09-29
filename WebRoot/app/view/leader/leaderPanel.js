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
//	/**
//	 * 显示用户信息并提供修改信息支持的form
//	 */
//	//显示用户信息的json读取器
//	var userJsonReader = Ext.create('Ext.data.JsonReader', {
//		 root : 'list',
//	    totalProperty : 'totalCount',
//	    id : 'id',
//	    successProperty : '@success',
//	    model : 'User'
//	});
//	var showUser = Ext.create("Ext.form.Panel", {
//		title : '我的资料',
//		frame : true,
//		height : 300,
//		width : 300,
//		reader : userJsonReader,
//		style : 'margin-left :40%;margin-top:3%;',
//		buttonAlign : 'center',
//		labelAlign : 'left',
//		defualts : {
//			labelSeparator : ' : '
//		},
//		defaultType : 'textfield',
//		items : [{
//			fieldLabel : '用户ID',
//			name : 'user.id',
//			id : 'id',
//			readOnly : true,
//			allowBlank : false,
//			maxLength : 8,
//			regex : /^[0-9]*$/,
//			regexText : '只能是数字，学生用学号，教职工用工号',
//			msgTarget : 'side'
//		}, {
//			fieldLabel : '用户名',
//			name : 'user.username',
//			allowBlank : false,
//			id : 'username',
//			maxLength : 20,
//			regex : /^[A-Za-z0-9]+$/,
//			regexText : '只能是数字、字母',
//			msgTarget : 'side'
//		}, {
//			name : 'user.password',
//			hidden : true,
//			id : 'password'
//		}, {
//			fieldLabel : '真实姓名',
//			name : 'user.relname',
//			id : 'relname',
//			allowBlank : false,
//			maxLength : 20,
//			msgTarget : 'side'
//		}, {
//			name : 'user.post.id',
//			hidden : true,
//			id : 'post.id'
//		}, {
//			fieldLabel : '职务',
//			name : 'user.post.postname',
//			id : 'post.postname',
//			readOnly : true,
//			allowBlank : false,
//			msgTarget : 'side'
//		}, {
//			fieldLabel : 'E-mail',
//			name : 'user.email',
//			id : 'email',
//			allowBlank : false,
//			regex : /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/,
//			regexText : '邮箱格式为XXX@XXX.com',
//			msgTarget : 'side'
//		}, {
//			fieldLabel : '电话',
//			name : 'user.tel',
//			id : 'tel',
//			allowBlank : false,
//			regex : /^[1][3-8]+\d{9}/,
//			regexText : '请输入正确的电话',
//			msgTarget : 'side'
//		}, {
//			fieldLabel : '班级',
//			name : 'user.clazz',
//			id : 'clazz',
//			allowBlank : true,
//			maxLength : 20,
//			msgTarget : 'side'
//		}, {
//			fieldLabel : 'QQ',
//			name : 'user.qq',
//			id : 'qq',
//			maxLength : 10,
//			allowBland : true,
//			msgTarget : 'side'
//		}],
//		buttons : [{
//			text : '保存',
//			iconCls : 'save',
//			disabled : false,
//			handler : function(b){
//				saveModifyUser(b.ownerCt.ownerCt);
//			}
//		}]
//	});
//	//为修改密码提供的自定义数据验证
//	Ext.apply(Ext.form.field.VTypes, {
//		pass : function(value, field){
//			if(field.confirmTo){
//				var pwd=Ext.getCmp(field.confirmTo);
//				if(value == pwd.getValue()){
//					return true;
//				} else {
//					return false;
//				}
//			}
//		},
//		passText : '两次密码输入不同'
//	});
//	/**
//	 * 修改密码窗体
//	 */
//	var modifyPass = Ext.create('Ext.form.Panel', {
//		title : '我的资料',
//		frame : true,
//		height : 200,
//		width : 300,
//		style : 'margin-left :40%;margin-top:10%;',
//		labelAlign : 'left',
//		defualts : {
//			labelSeparator : ' : '
//		},
//		defaultType : 'textfield',
//		items : [{
//			fieldLabel : '原始密码',
//			name : 'userDTO.prepass',
//			allowBlank : false,
//			maxLength : 20,
//			inputType : 'password',
//			regex : /^[\w]{6,}$/,
//			regexText : '密码只能包含数字、字母、下划线，长度不少于6位',
//			msgTarget : 'side'
//		}, {
//			fieldLabel : '新&nbsp;密&nbsp码',
//			name : 'userDTO.newpass',
//			id : 'newpass',
//			allowBlank : false,
//			maxLength : 20,
//			inputType : 'password',
//			regex : /^[\w]{6,}$/,
//			regexText : '密码只能包含数字、字母、下划线，长度不少于6位',
//			msgTarget : 'side'
//		}, {
//			fieldLabel : '确认密码',
//			name : 'userDTO.compass',
//			allowBlank : false,
//			maxLength : 20,
//			inputType : 'password',
//			regex : /^[\w]{6,}$/,
//			regexText : '密码只能包含数字、字母、下划线，长度不少于6位',
//			msgTarget : 'side',
//			vtype : 'pass',
//			confirmTo : 'newpass'
//		}],
//		buttons : [{
//			text : '确定',
//			iconCls : 'save',
//			disabled : false,
//			handler : function(b){
//				modifyPassword(b.ownerCt.ownerCt);
//			}
//		}]
//	});
//	/**
//	 * 显示用户以往消息的界面
//	 */
//	var OldMessagePanel = Ext.create("Ext.grid.Panel", {
//		title : '我的消息',//标题
//		width : 900,
//		height : 400,
//		style : 'margin:10px 12% 0;',
//		columns : [
//			{xtype : 'rownumberer'},
//			{text:'内容', dataIndex:'content', width : 600},
//			{text:'时间', dataIndex:'time', width : 120},
//			{header : "操作", xtype : 'actioncolumn', width : 100,
//				items : [{
//					icon : 'image/delete.ico',
//					tooltip : '删除',
//					handler : function(grid, row, col){
//						deleteMessage(grid, row, col);
//					}
//			}]}
//		],
//		store : Ext.data.StoreManager.lookup('userMessageStore'),
//		selType : 'checkboxmodel',
//		multiSelect : true,
//		tbar : [
//			{xtype : 'button', text : '删除', iconCls:'delete', style:'margin-left:40px;', handler: function(btn){deleteMessages(btn.ownerCt.ownerCt);}}
//		],
//		dockedItems : [{
//			xtype : 'pagingtoolbar',
//			store : Ext.data.StoreManager.lookup('userMessageStore'),
//			dock : 'bottom',
//			displayInfo : true
//		}],
//		frame : true,
//		loadMask : true
//	});
//	/**
//	 * 显示需要审核的用户的面板
//	 */
//	var RegisterUserPanel = Ext.create('Ext.grid.Panel', {
//		title : '用户审核',
//		width : 1000,
//		height : 400,
//		style : 'margin:10px 8% 0;',
//		columns : [
//			{xtype : 'rownumberer'},
//			{text:'编号', dataIndex:'id', width : 80},
//			{text:'昵称', dataIndex:'username', width :120},
//			{text:'姓名', dataIndex:'relname', width : 120},
//			{text:'职务', dataIndex:'post.postname', width : 60},
//			{text:'邮箱', dataIndex:'email', width : 150},
//			{text:'电话', dataIndex:'tel', width : 100},
//			{text:'注册日期', dataIndex:'regtime', width : 80},
//			{text:'班级', dataIndex:'clazz', width : 80},
//			{text:'QQ', dataIndex:'qq', width : 80},
//			{header : "操作", xtype : 'actioncolumn', width : 60,
//				items : [{
//					icon : 'image/confirm.ico',
//					tooltip : '通过',
//					handler : function(grid, row, col){
//						agreeUser(grid, row, col);
//					}
//				}, {
//					icon : 'image/refuse.ico',
//					tooltip : '拒绝',
//					handler : function(grid, row, col){
//						refuseUser(grid, row, col);
//					}
//				}]
//			}
//		],
//		store : Ext.data.StoreManager.lookup('RegisterUserStore'),
//		selType : 'checkboxmodel',
//		multiSelect : true,
//		tbar : [
//			{xtype : 'button', text : '通过', iconCls:'confirm', style:'margin-left:40px;', handler: function(btn){agreeUsers(btn.ownerCt.ownerCt);}},
//			{xtype : 'button', text : '拒绝', iconCls:'refuse', handler : function(btn){refuseUsers(btn.ownerCt.ownerCt);}}
//		],
//		dockedItems : [{
//			xtype : 'pagingtoolbar',
//			store : Ext.data.StoreManager.lookup('RegisterUserStore'),
//			dock : 'bottom',
//			displayInfo : true
//		}],
//		frame : true,
//		loadMask : true
//	});
//	/**
//	 * 显示临时申领信息
//	 */
//	var TempBorrowPanel = Ext.create('Ext.grid.Panel', {
//		title : '申领审核',
//		width : 1000,
//		height : 400,
//		style : 'margin:10px 8% 0;',
//		columns : [
//			{xtype : 'rownumberer'},
//			{text:'申请人编号', dataIndex:'applicant.id', width : 80},
//			{text:'申请人姓名', dataIndex:'applicant.relname', width :80},
//			{text:'申请人职务', dataIndex:'applicant.post.postname', width : 80},
//			{text:'器件编号', dataIndex:'element.id', width : 80},
//			{text:'器件名称', dataIndex:'element.elementname', width : 100},
//			{text:'器件类型', dataIndex:'element.type.typename', width : 60},
//			{text:'封装类型', dataIndex:'element.feature', width : 80},
//			{text:'储物柜', dataIndex:'element.locker.id', width : 50},
//			{text:'仓库', dataIndex:'element.locker.addr', width : 50},
//			{text:'库存量', dataIndex:'element.store', width : 50, 
//				renderer : function(value){
//					if(value == 0){
//						return '<font color=red>' + value + '</font>';
//					} else{
//						return '<font color=black>' + value + '</font>';
//					}
//				}
//			},
//			{text:'申请数量', dataIndex:'count', width : 80},
//			{text:'申请日期', dataIndex:'time', width : 80},
//			{header : "操作", xtype : 'actioncolumn', width : 80,
//				items : [{
//					icon : 'image/confirm.ico',
//					tooltip : '通过',
//					handler : function(grid, row, col){
//						agreeBorrow(grid, row, col);
//					}
//				}, {
//					icon : 'image/refuse.ico',
//					tooltip : '拒绝',
//					handler : function(grid, row, col){
//						refuseBorrow(grid, row, col);
//					}
//				}]
//			}
//		],
//		store : Ext.data.StoreManager.lookup('adminTempBorrowStore'),
//		selType : 'checkboxmodel',
//		multiSelect : true,
//		tbar : [
//			{xtype : 'button', text : '通过', iconCls:'confirm', style:'margin-left:40px;', handler: function(btn){agreeBorrows(btn.ownerCt.ownerCt);}},
//			{xtype : 'button', text : '拒绝', iconCls:'refuse', handler : function(btn){refuseBorrows(btn.ownerCt.ownerCt);}}
//		],
//		dockedItems : [{
//			xtype : 'pagingtoolbar',
//			store : Ext.data.StoreManager.lookup('adminTempBorrowStore'),
//			dock : 'bottom',
//			displayInfo : true
//		}],
//		frame : true,
//		loadMask : true
//	});
//	/**
//	 * 显示临时申购信息
//	 */
//	var TempPorPanel = Ext.create('Ext.grid.Panel', {
//		title : '申购审核',
//		width : 1000,
//		height : 400,
//		style : 'margin:10px 8% 0;',
//		columns : [
//			{xtype : 'rownumberer'},
//			{text:'申请人编号', dataIndex:'applicant.id', width : 100},
//			{text:'申请人姓名', dataIndex:'applicant.relname', width :100},
//			{text:'申请人职务', dataIndex:'applicant.post.postname', width : 80},
//			{text:'器件名称', dataIndex:'tempElement.elementname', width : 120},
//			{text:'器件类型', dataIndex:'tempElement.type.typename', width : 80},
//			{text:'封装类型', dataIndex:'tempElement.feature', width : 100},
//			{text:'单价', dataIndex:'tempElement.price', width : 80},
//			{text:'数量', dataIndex:'tempElement.count', width : 80},
//			{text:'申请日期', dataIndex:'time', width : 100},
//			{header : "操作", xtype : 'actioncolumn', width : 100,
//				items : [{
//					icon : 'image/confirm.ico',
//					tooltip : '通过',
//					handler : function(grid, row, col){
//						agreePor(grid, row, col);
//					}
//				}, {
//					icon : 'image/refuse.ico',
//					tooltip : '拒绝',
//					handler : function(grid, row, col){
//						refusePor(grid, row, col);
//					}
//				}]
//			}
//		],
//		store : Ext.data.StoreManager.lookup('adminTempPorStore'),
//		selType : 'checkboxmodel',
//		multiSelect : true,
//		tbar : [
//			{xtype : 'button', text : '通过', iconCls:'confirm', style:'margin-left:40px;', handler: function(btn){agreePors(btn.ownerCt.ownerCt);}},
//			{xtype : 'button', text : '拒绝', iconCls:'refuse', handler : function(btn){refusePors(btn.ownerCt.ownerCt);}}
//		],
//		dockedItems : [{
//			xtype : 'pagingtoolbar',
//			store : Ext.data.StoreManager.lookup('adminTempPorStore'),
//			dock : 'bottom',
//			displayInfo : true
//		}],
//		frame : true,
//		loadMask : true
//	});
//	/**
//	 * 显示申领记录
//	 */
//	var BorrowRecordPanel = Ext.create('Ext.tab.Panel', {
//		title : '申领记录',
//		width : 1000,
//		height : 400,
//		style : 'margin:10px 8% 0;',
//		activeTap : 0,
//		items : [{
//			title : '已通过',
//			xtype : 'gridpanel',
//			columns : [
//			{xtype : 'rownumberer'},
//			{text:'申请人编号', dataIndex:'applicant.id', width : 70},
//			{text:'申请人姓名', dataIndex:'applicant.relname', width :70},
//			{text:'申请人职务', dataIndex:'applicant.post.postname', width : 80},
//			{text:'器件编号', dataIndex:'element.id', width : 80},
//			{text:'器件名称', dataIndex:'element.elementname', width : 80},
//			{text:'器件类型', dataIndex:'element.type.typename', width : 60},
//			{text:'封装类型', dataIndex:'element.feature', width : 60},
//			{text:'储物柜', dataIndex:'element.locker.id', width : 50},
//			{text:'仓库', dataIndex:'element.locker.addr', width : 40},
//			{text:'库存量', dataIndex:'element.store', width : 50,
//				renderer : function(value){
//					if(value == 0){
//						return '<font color=red>' + value + '</font>';
//					} else{
//						return '<font color=black>' + value + '</font>';
//					}
//				}
//			},
//			{text:'申请数量', dataIndex:'count', width : 60},
//			{text:'申请日期', dataIndex:'time', width : 60},
//			{text:'审核人', dataIndex:'verifier.relname', width:60},
//			{text:'状态', dataIndex:'returned', width:60, 
//				renderer : function(value){
//					if(value == -1){
//						return '<font color="#BEBCBC">无需归还</font>';
//					} else if(value == 0){
//						return '<font color=red>未归还</font>';
//					} else{
//						return '<font color=black>已归还</font>';
//					}
//				}
//			}],
//			store : Ext.data.StoreManager.lookup('adminPassBorrowStore'),
//			selType : 'checkboxmodel',
//			multiSelect : true,
//			dockedItems : [{
//				xtype : 'pagingtoolbar',
//				store : Ext.data.StoreManager.lookup('adminPassBorrowStore'),
//				dock : 'bottom',
//				displayInfo : true
//			}],
//			frame : true,
//			loadMask : true
//		}, {
//			title : '已拒绝',
//			xtype : 'gridpanel',
//			columns : [
//				{xtype : 'rownumberer'},
//				{text:'申请人编号', dataIndex:'applicant.id', width : 70},
//				{text:'申请人姓名', dataIndex:'applicant.relname', width :70},
//				{text:'申请人职务', dataIndex:'applicant.post.postname', width : 80},
//				{text:'器件编号', dataIndex:'element.id', width : 80},
//				{text:'器件名称', dataIndex:'element.elementname', width : 100},
//				{text:'器件类型', dataIndex:'element.type.typename', width : 60},
//				{text:'封装类型', dataIndex:'element.feature', width : 65},
//				{text:'储物柜', dataIndex:'element.locker.id', width : 50},
//				{text:'仓库', dataIndex:'element.locker.addr', width : 50},
//				{text:'库存量', dataIndex:'element.store', width : 50, 
//					renderer : function(value){
//					if(value == 0){
//						return '<font color=red>' + value + '</font>';
//					} else{
//						return '<font color=black>' + value + '</font>';
//					}
//				}
//				},
//				{text:'申请数量', dataIndex:'count', width : 60},
//				{text:'申请日期', dataIndex:'time', width : 80},
//				{text:'审核人', dataIndex:'verifier.relname', width:60
//			}],
//			store : Ext.data.StoreManager.lookup('adminRefuseBorrowStore'),
//			selType : 'checkboxmodel',
//			multiSelect : true,
//			dockedItems : [{
//				xtype : 'pagingtoolbar',
//				store : Ext.data.StoreManager.lookup('adminRefuseBorrowStore'),
//				dock : 'bottom',
//				displayInfo : true
//			}],
//			frame : true,
//			loadMask : true
//		}]
//	});
//	//为tabpanel添加切换事件
//	BorrowRecordPanel.on('tabchange', function(tabPanel, newCard, oldCard){
//		if(newCard.title == '已通过')
//			Ext.data.StoreManager.lookup('adminPassBorrowStore').load({
//				params : {
//					start : 0,
//					page : 1,
//					limit : 15
//				}
//			});
//		else
//			Ext.data.StoreManager.lookup('adminRefuseBorrowStore').load({
//				params : {
//					start : 0,
//					page : 1,
//					limit : 15
//				}
//			});
//	});
//	/**
//	 * 显示申购记录
//	 */
//	var PorRecordPanel = Ext.create('Ext.tab.Panel', {
//		title : '申购记录',
//		width : 1000,
//		height : 400,
//		style : 'margin:10px 8% 0;',
//		activeTap : 0,
//		items : [{
//			title : '已通过',
//			xtype : 'gridpanel',
//			columns : [
//				{xtype : 'rownumberer'},
//				{text:'申请人编号', dataIndex:'applicant.id', width : 80},
//				{text:'申请人姓名', dataIndex:'applicant.relname', width :80},
//				{text:'申请人职务', dataIndex:'applicant.post.postname', width : 80},
//				{text:'器件名称', dataIndex:'tempElement.elementname', width : 115},
//				{text:'器件类型', dataIndex:'tempElement.type.typename', width : 80},
//				{text:'封装类型', dataIndex:'tempElement.feature', width : 100},
//				{text:'单价', dataIndex:'tempElement.price', width : 80},
//				{text:'数量', dataIndex:'tempElement.count', width : 80},
//				{text:'申请日期', dataIndex:'time', width : 80
//			}],
//			store : Ext.data.StoreManager.lookup('adminPassPorStore'),
//			dockedItems : [{
//				xtype : 'pagingtoolbar',
//				store : Ext.data.StoreManager.lookup('adminPassPorStore'),
//				dock : 'bottom',
//				displayInfo : true
//			}],
//			frame : true,
//			loadMask : true
//		}, {
//			title : '已拒绝',
//			xtype : 'gridpanel',
//			columns : [
//				{xtype : 'rownumberer'},
//				{text:'申请人编号', dataIndex:'applicant.id', width : 80},
//				{text:'申请人姓名', dataIndex:'applicant.relname', width :80},
//				{text:'申请人职务', dataIndex:'applicant.post.postname', width : 80},
//				{text:'器件名称', dataIndex:'tempElement.elementname', width : 115},
//				{text:'器件类型', dataIndex:'tempElement.type.typename', width : 80},
//				{text:'封装类型', dataIndex:'tempElement.feature', width : 100},
//				{text:'单价', dataIndex:'tempElement.price', width : 80},
//				{text:'数量', dataIndex:'tempElement.count', width : 80},
//				{text:'申请日期', dataIndex:'time', width : 80},
//				{text:'审核人', dataIndex:'verifier.relname', width:80
//			}],
//			store : Ext.data.StoreManager.lookup('adminRefusePorStore'),
//			selType : 'checkboxmodel',
//			multiSelect : true,
//			dockedItems : [{
//				xtype : 'pagingtoolbar',
//				store : Ext.data.StoreManager.lookup('adminRefusePorStore'),
//				dock : 'bottom',
//				displayInfo : true
//			}],
//			frame : true,
//			loadMask : true
//		}]
//	});
//	//为tabpanel添加切换事件
//	PorRecordPanel.on('tabchange', function(tabPanel, newCard, oldCard){
//		if(newCard.title == '已通过')
//			Ext.data.StoreManager.lookup('adminPassPorStore').load({
//				params : {
//					start : 0,
//					page : 1,
//					limit : 15
//				}
//			});
//		else
//			Ext.data.StoreManager.lookup('adminRefusePorStore').load({
//				params : {
//					start : 0,
//					page : 1,
//					limit : 15
//				}
//			});
//	});
//	/**
//	 * 新消息显示窗口
//	 */
//	var NewMessageWindow = Ext.create('Ext.window.Window', {
//		title : '新消息',
//		width : 900,
//		height : 500,
//		layout : 'fit',
//		plain : true,
//		closeAction : 'hide',
//		resizable : 'false',
//		items : {
//			xtype : 'gridpanel',
//			columns : [
//				{xtype : 'rownumberer'},
//				{text:'内容', dataIndex:'content', width : 600},
//				{text:'时间', dataIndex:'time', width : 120},
//				{header : "操作", xtype : 'actioncolumn', width : 100,
//					items : [{
//						icon : 'image/confirm.ico',
//						tooltip : '标记为已读',
//						handler : function(grid, row, col){
//							checkMessage(grid, row, col);
//						}
//				}]}
//			],
//			store : Ext.data.StoreManager.lookup('newMessageStore'),
//			selType : 'checkboxmodel',
//			multiSelect : true,
//			tbar : [
//				{xtype : 'button', text : '标记为已读', iconCls:'confirm', style:'margin-left:40px;', handler: function(btn){checkMessages(btn.ownerCt.ownerCt);}}
//			],
//			dockedItems : [{
//				xtype : 'pagingtoolbar',
//				store : Ext.data.StoreManager.lookup('newMessageStore'),
//				dock : 'bottom',
//				displayInfo : true
//			}],
//			frame : true,
//			loadMask : true
//		}
//	});
//	
//	var aNewMessage = Ext.get('newMessage');
//	aNewMessage.on('click', function(){
//		NewMessageWindow.show();
//		Ext.data.StoreManager.lookup('newMessageStore').load({
//			params : {
//				start : 0,
//				page : 1,
//				limit : 15
//			}});
//	});
//	
//	//为树形菜单增加单击时间，根据id判断要添加的面板
//	superAdminMenu.on({
//		'itemclick' : function(view, record, item, index, event, options){
//			if(record.get('leaf')){
//				showModifyUser(record, mainPanel, showUser);
//				showModifyPass(record, mainPanel, modifyPass);
//				showMyMessage(record, mainPanel, OldMessagePanel, Ext.data.StoreManager.lookup('userMessageStore'));
//				showUserAudit(record, mainPanel, RegisterUserPanel, Ext.data.StoreManager.lookup('RegisterUserStore'));
//				showTempBorrowAudit(record, mainPanel, TempBorrowPanel, Ext.data.StoreManager.lookup('adminTempBorrowStore'));
//				showTempPorAudit(record, mainPanel, TempPorPanel, Ext.data.StoreManager.lookup('adminTempPorStore'));
//				showBorrowRecordPanel(record, mainPanel, BorrowRecordPanel, Ext.data.StoreManager.lookup('adminPassBorrowStore'));
//				showPorRecordPanel(record, mainPanel, PorRecordPanel, Ext.data.StoreManager.lookup('adminPassPorStore'));
//				//消除HTML div上的内容
//				var mainDiv = Ext.getDom('main');
//				mainDiv.innerHTML = '';
//			}
//		}
//	});
});