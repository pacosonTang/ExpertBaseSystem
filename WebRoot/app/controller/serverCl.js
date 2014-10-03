/**
 * 显示我的资料
 */
var showMe = function(record, mainPanel, showUser){
	if(record.get('id') == 'myInfo'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(showUser).doLayout();
		showUser.show();
		showUser.form.load({
			url : 'common/showUser.action',
			method : 'POST',
			waitMsg : '数据正在加载...',
			waitTitle : '请稍后',
			timeout : 5000,
			failure : function(form, action){
				Ext.Msg.alert('信息', '数据加载失败！');
			}
		});
	}else{
		showUser.hide();
	}
};

/**
 * 显示账户修改面板
 */
var showCount = function(record, mainPanel, countFP){
	if(record.get('id')=='modifyCount'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(countFP).doLayout();
		countFP.show();
	} else {
		countFP.hide();
	}
};
/**
 * 显示会员面板
 */
var showUsers = function(record, mainPanel, panel, store){
	if(record.get('id')=='memberSearch'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(panel).doLayout();
		store.load();
		panel.show();
	} else {
		panel.hide();
	}
};

//查看会员详情
var showMember = function(grid, row, memberWindow){
	var record = grid.getStore().getAt(row);
	var memberFP = memberWindow.down('form');
	
	memberFP.down('image').setSrc('img/nopicture.jpg');
	
	memberFP.down('[name=user.realname]').setValue(record.get('realname'));
	memberFP.down('[name=user.sex]').setValue(record.get('sex'));
	memberFP.down('[name=user.idNo]').setValue(record.get('idNo'));
	memberFP.down('[name=user.school]').setValue(record.get('school'));
	memberFP.down('[name=user.major.name]').setValue(record.get('major.name'));
	memberFP.down('[name=user.workUnit]').setValue(record.get('workUnit'));
	memberFP.down('[name=user.title]').setValue(record.get('title'));
	memberFP.down('[name=user.duty]').setValue(record.get('duty'));
	memberFP.down('[name=user.address]').setValue(record.get('address'));
	memberFP.down('[name=user.telephone]').setValue(record.get('telephone'));
	memberFP.down('[name=user.officePhone]').setValue(record.get('officePhone'));
	memberFP.down('[name=user.email]').setValue(record.get('email'));
	memberFP.down('[name=user.postcode]').setValue(record.get('postcode'));
	memberFP.down('[name=user.qq]').setValue(record.get('qq'));
	memberFP.down('[name=user.currentMajor]').setValue(record.get('currentMajor'));
	memberFP.down('[name=user.adept]').setValue(record.get('adept'));
	if(record.get('avatar') != null && record.get('avatar') != ''){
		memberFP.down('image').setSrc('uploads/' + record.get('avatar'));
	}
	memberFP.down('[name=user.birthday]').setValue(record.get('birthday'));
	memberFP.down('[name=user.graduateTime]').setValue(record.get('graduateTime'));
	memberFP.down('[name=user.institution.name]').setValue(record.get('institution.name'));
	memberFP.down('[name=user.degree.name]').setValue(record.get('degree.name'));
	memberFP.down('[name=user.education.name]').setValue(record.get('education.name'));
	memberFP.down('[name=thesis]').getStore().load({
		params : {
			userId : record.get('id')
		}
	});
	memberFP.down('[name=patent]').getStore().load({
		params : {
			userId : record.get('id')
		}
	});
	memberFP.down('[name=project]').getStore().load({
		params : {
			userId : record.get('id')
		}
	});
	memberFP.down('[name=award]').getStore().load({
		params : {
			userId : record.get('id')
		}
	});
	memberWindow.show();
};

var saveMe = function(userFP){
	if(userFP.form.isValid()){
		userFP.form.submit({
			url : 'common/modifyUser.action',
			success : function(form, action){
				Ext.Msg.alert('信息', '保存成功！');
			},
			failure : function(form, action){
				Ext.Msg.alert('信息', '保存失败，请重试...');
			}
		});
	}
};
/**
 * 修改账户
 */
var modifyCount = function(modifyCountFP){
	if(modifyCountFP.form.isValid()){
		Ext.Msg.confirm('提示', '确定要修改你的账户吗？', function(opt){
			if(opt == 'yes'){
				modifyCountFP.form.submit({
					url : 'common/modifyCount.action',
					method : 'POST',
					success : function(form, action){
						Ext.Msg.alert('信息', '账户修改成功，请牢记你的账户！');
					},
					failure : function(form, action){
						Ext.Msg.alert('信息', '账户修改失败，' + action.result.errorMessage);
					}
				});
			}
		});
	}else{
		Ext.Msg.alert('提示', '请正确填写信息！');
	}
};