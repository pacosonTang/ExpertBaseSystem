//显示或隐藏修改用户信息面板
var showUserForm = function(record, mainPanel, showUser){
	if(record.get('id')=='myInfo'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(showUser).doLayout();
		showUser.show();
		showUser.form.load({
			url : 'common/showUser',
			method : 'POST',
			waitMsg : '数据正在加载...',
			waitTitle : '请稍后',
			timeout : 10,
			failure : function(form, action){
				Ext.Msg.alert('信息', '数据加载失败！');
			}
		});
	} else {
		showUser.hide();
	}
};