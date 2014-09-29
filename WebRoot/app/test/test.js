Ext.onReady(function(){
	Ext.QuickTips.init();
	
	var form = Ext.create('Ext.form.Panel', {
		title : '测试',
		frame : true,
		width : 200,
		height : 200,
		renderTo : 'test',
		labelAlign : 'left',
		defualts : {
			labelSeparator : ' : '
		},
		defaultType : 'textfield',
		items : [{
			fieldLabel : '用户ID',
			name : 'user.id',
			id : 'userid',
			allowBlank : false,
			maxLength : 8,
			regex : /^[0-9]*$/,
			regexText : '只能是数字，学生用学号，教职工用工号',
			msgTarget : 'side'
		}, {
			fieldLabel : '用户名',
			name : 'user.username',
			allowBlank : false,
			id : 'username',
			maxLength : 20,
			regex : /^[A-Za-z0-9]+$/,
			regexText : '只能是数字、字母',
			msgTarget : 'side'
		}]
	});
});