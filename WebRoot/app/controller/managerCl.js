/**
 * 显示或隐藏用户管理面板
 */
var showMembers = function(record, mainPanel, MembersPanel, store){
	if(record.get('id')=='memberManage'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(MembersPanel).doLayout();
		MembersPanel.show();
		store.load({
			params : {
				start : 0,
				page : 1,
				limit : 15
			}
		});
	} else {
		MembersPanel.hide();
	}
};
/**
 * 显示或隐藏领导管理面板
 */
var showLeaders = function(record, mainPanel, LeadersGP, store){
	if(record.get('id')=='leaderManage'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(LeadersGP).doLayout();
		LeadersGP.show();
		store.load();
	} else {
		LeadersGP.hide();
	}
};
/**
 * 显示或隐藏领导管理面板
 */
var showServers = function(record, mainPanel, ServersGP, store){
	if(record.get('id')=='serverManage'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(ServersGP).doLayout();
		ServersGP.show();
		store.load();
	} else {
		ServersGP.hide();
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
 * 显示学科管理面板
 */
var showSubjects = function(record, mainPanel, subjectsGP, store){
	if(record.get('id') == 'subjectManage'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(subjectsGP).doLayout();
		subjectsGP.show();
		store.load();
	}else{
		subjectsGP.hide();
	}
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
 * 保存新的会员信息
 */
var addMember = function(memberFP, store){
	if(memberFP.form.isValid()){
		memberFP.form.submit({
			url : 'manager/addMember.action',
			success : function(form, action){
				Ext.Msg.alert('信息', '保存成功！');
				store.load();
				memberFP.form.reset();
				memberFP.down('image').setSrc('img/nopicture.jpg');
			},
			failure : function(form, action){
				Ext.Msg.alert('信息', '保存失败，请重新再试！');
			}
		});
	} else {
		Ext.Msg.alert('警告', '请正确填写信息再保存！');
	}
};
var addLeader = function(leaderFP, store){
	if(leaderFP.form.isValid()){
		leaderFP.form.submit({
			url : 'manager/addLeader.action',
			success : function(form, action){
				Ext.Msg.alert('信息', '保存成功！');
				store.load();
				leaderFP.form.reset();
			},
			failure : function(form, action){
				Ext.Msg.alert('信息', '保存失败，请重新再试！');
			}
		});
	} else {
		Ext.Msg.alert('警告', '请正确填写信息再保存！');
	}
};
var addServer = function(serverFP, store){
	if(serverFP.form.isValid()){
		serverFP.form.submit({
			url : 'manager/addServer.action',
			success : function(form, action){
				Ext.Msg.alert('信息', '保存成功！');
				store.load();
				serverFP.form.reset();
			},
			failure : function(form, action){
				Ext.Msg.alert('信息', '保存失败，请重新再试！');
			}
		});
	} else {
		Ext.Msg.alert('警告', '请正确填写信息再保存！');
	}
};

//下面四个添加方法原理相同
/**
 * 保存新论文信息
 * @param thesisForm 填写论文信息的表单
 * @param store 显示当前用户所有论文信息的store
 * @param userId 当前用户的ID
 * @returns NULL
 */
var addThesis = function(window, thesisForm, store, userId){
	if(thesisForm.form.isValid()){
		thesisForm.form.submit({
			url : 'common/addThesis.action?userId=' + userId,
			success : function(form, action){
				store.load({
					params : {
						userId : userId
					}
				});
				window.focus();
				thesisForm.form.reset();
			},
			failure : function(form, action){
				Ext.Msg.alert('信息', '保存失败，请重试...');
			}
		});
	} else {
		Ext.Msg.alert('警告', '请正确填写论文信息再保存！');
	}
};

var addPatent = function(window, patentForm, store, userId){
	if(patentForm.form.isValid()){
		patentForm.form.submit({
			url : 'common/addPatent.action?userId=' + userId,
			success : function(form, action){
				store.load({
					params : {
						userId : userId
					}
				});
				window.focus();
				patentForm.form.reset();
			},
			failure : function(form, action){
				Ext.Msg.alert('信息', '保存失败，请重试...');
			}
		});
	} else {
		Ext.Msg.alert('警告', '请正确填写专利信息再保存！');
	}
};

var addProject = function(window, projectForm, store, userId){
	if(projectForm.form.isValid()){
		projectForm.form.submit({
			url : 'common/addProject.action?userId=' + userId,
			success : function(form, action){
				store.load({
					params : {
						userId : userId
					}
				});
				window.focus();
				projectForm.form.reset();
			},
			failure : function(form, action){
				Ext.Msg.alert('信息', '保存失败，请重试...');
			}
		});
	} else {
		Ext.Msg.alert('警告', '请正确填写项目信息再保存！');
	}
};

var addAward = function(window, awardForm, store, userId){
	if(awardForm.form.isValid()){
		awardForm.form.submit({
			url : 'common/addAward.action?userId=' + userId,
			success : function(form, action){
				store.load({
					params : {
						userId : userId
					}
				});
				window.focus();
				awardForm.form.reset();
			},
			failure : function(form, action){
				Ext.Msg.alert('信息', '保存失败，请重试...');
			}
		});
	} else {
		Ext.Msg.alert('警告', '请正确填写奖励信息再保存！');
	}
};
/**
 * 删除单个会员
 * @param grid 显示会员的gridpanel
 * @param row 当前会员信息在gridpanel中的行号
 * @param col
 * @returns NULL
 */
var deleteMember = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	Ext.Msg.confirm('提示', '确定要删除该会员信息吗？', function(opt){
		if(opt == 'yes'){
			var selectIds = record.get('id');
			
			Ext.Ajax.request({
				url : 'manager/deleteMembers.action',
				params : {selectIds : selectIds},
				method : 'POST',
				timeout : 5000,
				success : function(response){
					Ext.Msg.alert('信息', '删除成功！');
					grid.getStore().remove(record);
				},
				failure : function(response){
					Ext.Msg.alert('信息', '删除失败，请重试...');
				}
			});
		}
	});
};
/**
 * 删除选中的会员
 * @param grid 显示会员信息的girdpanel
 * @returns
 */
var deleteMembers = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要删除的会员！');
	}else{
		Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(i == 0){
						selectIds += record[i].get('id');
					} else {
						selectIds += ',' + record[i].get('id');
					}
				}
		
				Ext.Ajax.request({
					url : 'manager/deleteMembers.action',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 5000,
					success : function(response){
						Ext.Msg.alert('信息', '删除成功！');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '删除失败，请重试...');
					}
				});
			}
		});
	}
};
var deleteLeader = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	Ext.Msg.confirm('提示', '确定要删除该领导信息吗？', function(opt){
		if(opt == 'yes'){
			var selectIds = record.get('id');
			
			Ext.Ajax.request({
				url : 'manager/deleteLeaders.action',
				params : {selectIds : selectIds},
				method : 'POST',
				timeout : 5000,
				success : function(response){
					Ext.Msg.alert('信息', '删除成功！');
					grid.getStore().remove(record);
				},
				failure : function(response){
					Ext.Msg.alert('信息', '删除失败，请重试...');
				}
			});
		}
	});
};
var deleteLeaders = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要删除的领导！');
	}else{
		Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(i == 0){
						selectIds += record[i].get('id');
					} else {
						selectIds += ',' + record[i].get('id');
					}
				}
		
				Ext.Ajax.request({
					url : 'manager/deleteLeaders.action',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 5000,
					success : function(response){
						Ext.Msg.alert('信息', '删除成功！');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '删除失败，请重试...');
					}
				});
			}
		});
	}
};
var deleteServer = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	Ext.Msg.confirm('提示', '确定要删除该领导信息吗？', function(opt){
		if(opt == 'yes'){
			var selectIds = record.get('id');
			
			Ext.Ajax.request({
				url : 'manager/deleteServers.action',
				params : {selectIds : selectIds},
				method : 'POST',
				timeout : 5000,
				success : function(response){
					Ext.Msg.alert('信息', '删除成功！');
					grid.getStore().remove(record);
				},
				failure : function(response){
					Ext.Msg.alert('信息', '删除失败，请重试...');
				}
			});
		}
	});
};
var deleteServers = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要删除的领导！');
	}else{
		Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(i == 0){
						selectIds += record[i].get('id');
					} else {
						selectIds += ',' + record[i].get('id');
					}
				}
		
				Ext.Ajax.request({
					url : 'manager/deleteServers.action',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 5000,
					success : function(response){
						Ext.Msg.alert('信息', '删除成功！');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '删除失败，请重试...');
					}
				});
			}
		});
	}
};

var deleteThesis = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	Ext.Msg.confirm('提示', '确定要删除该信息吗？', function(opt){
		if(opt == 'yes'){
			var selectIds = record.get('id');
			
			Ext.Ajax.request({
				url : 'common/deleteThesises.action',
				params : {selectIds : selectIds},
				method : 'POST',
				timeout : 5000,
				success : function(response){
					Ext.Msg.alert('信息', '删除成功！');
					grid.getStore().remove(record);
				},
				failure : function(response){
					Ext.Msg.alert('信息', '删除失败，请重试...');
				}
			});
		}
	});
};
var deleteThesises = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要删除的论文！');
	}else{
		Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(i == 0){
						selectIds += record[i].get('id');
					} else {
						selectIds += ',' + record[i].get('id');
					}
				}
		
				Ext.Ajax.request({
					url : 'common/deleteThesises.action',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 5000,
					success : function(response){
						Ext.Msg.alert('信息', '删除成功！');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '删除失败，请重试...');
					}
				});
			}
		});
	}
};

var deletePatent = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	Ext.Msg.confirm('提示', '确定要删除该信息吗？', function(opt){
		if(opt == 'yes'){
			var selectIds = record.get('id');
			
			Ext.Ajax.request({
				url : 'common/deletePatents.action',
				params : {selectIds : selectIds},
				method : 'POST',
				timeout : 5000,
				success : function(response){
					Ext.Msg.alert('信息', '删除成功！');
					grid.getStore().remove(record);
				},
				failure : function(response){
					Ext.Msg.alert('信息', '删除失败，请重试...');
				}
			});
		}
	});
};
var deletePatents = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要删除的专利！');
	}else{
		Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(i == 0){
						selectIds += record[i].get('id');
					} else {
						selectIds += ',' + record[i].get('id');
					}
				}
		
				Ext.Ajax.request({
					url : 'common/deletePatents.action',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 5000,
					success : function(response){
						Ext.Msg.alert('信息', '删除成功！');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '删除失败，请重试...');
					}
				});
			}
		});
	}
};

var deleteProject = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	Ext.Msg.confirm('提示', '确定要删除该信息吗？', function(opt){
		if(opt == 'yes'){
			var selectIds = record.get('id');
			
			Ext.Ajax.request({
				url : 'common/deleteProjects.action',
				params : {selectIds : selectIds},
				method : 'POST',
				timeout : 5000,
				success : function(response){
					Ext.Msg.alert('信息', '删除成功！');
					grid.getStore().remove(record);
				},
				failure : function(response){
					Ext.Msg.alert('信息', '删除失败，请重试...');
				}
			});
		}
	});
};
var deleteProjects = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要删除的项目！');
	}else{
		Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(i == 0){
						selectIds += record[i].get('id');
					} else {
						selectIds += ',' + record[i].get('id');
					}
				}
		
				Ext.Ajax.request({
					url : 'common/deleteProjects.action',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 5000,
					success : function(response){
						Ext.Msg.alert('信息', '删除成功！');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '删除失败，请重试...');
					}
				});
			}
		});
	}
};

var deleteAward = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	Ext.Msg.confirm('提示', '确定要删除该信息吗？', function(opt){
		if(opt == 'yes'){
			var selectIds = record.get('id');
			
			Ext.Ajax.request({
				url : 'common/deleteAwards.action',
				params : {selectIds : selectIds},
				method : 'POST',
				timeout : 5000,
				success : function(response){
					Ext.Msg.alert('信息', '删除成功！');
					grid.getStore().remove(record);
				},
				failure : function(response){
					Ext.Msg.alert('信息', '删除失败，请重试...');
				}
			});
		}
	});
};
var deleteAwards = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要删除的奖励！');
	}else{
		Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(i == 0){
						selectIds += record[i].get('id');
					} else {
						selectIds += ',' + record[i].get('id');
					}
				}
		
				Ext.Ajax.request({
					url : 'common/deleteAwards.action',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 5000,
					success : function(response){
						Ext.Msg.alert('信息', '删除成功！');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '删除失败，请重试...');
					}
				});
			}
		});
	}
};
/**
 * 删除学科专业
 */
var deleteSubject = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	Ext.Msg.confirm('提示', '删除该专业将删除该学科下的所有子专业，确认删除吗？', function(opt){
		if(opt == 'yes'){
			var selectIds = record.get('id');
			
			Ext.Ajax.request({
				url : 'manager/deleteSubjects.action',
				params : {selectIds : selectIds},
				method : 'POST',
				timeout : 5000,
				success : function(response){
					Ext.Msg.alert('信息', '删除成功！');
					grid.getStore().remove(record);
				},
				failure : function(response){
					Ext.Msg.alert('信息', '删除失败，请重试...');
				}
			});
		}
	});
};
var deleteSubjects = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要删除的学科！');
	}else{
		Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(i == 0){
						selectIds += record[i].get('id');
					} else {
						selectIds += ',' + record[i].get('id');
					}
				}
		
				Ext.Ajax.request({
					url : 'manager/deleteSubjects.action',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 5000,
					success : function(response){
						Ext.Msg.alert('信息', '删除成功！');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '删除失败，请重试...');
					}
				});
			}
		});
	}
};
//添加一级学科
var addFirst = function(firstFP, store){
	if(firstFP.form.isValid()){
		firstFP.form.submit({
			url : 'manager/addSubject.action',
			method : 'POST',
			success : function(form, aciton){
				firstFP.form.reset();
				store.load();
			}
		});
	}else{
		Ext.Msg.alert('警告', '请正确填写信息...');
	}
};
//添加二级学科
var addSecond = function(secondFP, store){
	if(secondFP.form.isValid()){
		secondFP.form.submit({
			url : 'manager/addSecondSubject.action',
			method : 'POST',
			success : function(form, aciton){
				secondFP.form.reset();
				store.load();
			}
		});
	}else{
		Ext.Msg.alert('警告', '请正确填写信息...');
	}
};
//添加三级学科
var addThird = function(thirdFP, store){
	if(thirdFP.form.isValid()){
		thirdFP.form.submit({
			url : 'manager/addSecondSubject.action',
			method : 'POST',
			success : function(form, aciton){
				thirdFP.form.reset();
				store.load();
			}
		});
	}else{
		Ext.Msg.alert('警告', '请正确填写信息...');
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
//上传图片
var savaImg = function(imgFP, userFP){
	if(imgFP.form.isValid()){
		imgFP.form.submit({
			url : 'manager/upload.action',
			success : function(form, action){
				userFP.down('image').setSrc('uploads/' + action.result.imgName);
				userFP.down('[name=user.avatar]').setValue(action.result.imgName);
				imgFP.form.reset();
				imgFP.up('window').hide();
				Ext.Msg.alert('信息', '照片修改成功...');
			},
			failure : function(form, action){
				Ext.Msg.alert('信息', action.result.errorMessage);
			}
		});
	}else{
		Ext.Msg.alert('警告', '请选择文件...');
	}
};
//查看会员详情
var showMember = function(grid, row, modifyMemberWindow){
	var record = grid.getStore().getAt(row);
	var memberFP = modifyMemberWindow.down('form');
	
	memberFP.down('[name=user.id]').setValue(record.get('id'));
	memberFP.down('[name=user.realname]').setValue(record.get('realname'));
	memberFP.down('[name=user.username]').setValue(record.get('username'));
	memberFP.down('[name=user.password]').setValue(record.get('password'));
	memberFP.down('[name=user.sex]').setValue(record.get('sex'));
	memberFP.down('[name=user.idNo]').setValue(record.get('idNo'));
	memberFP.down('[name=user.school]').setValue(record.get('school'));
	memberFP.down('[name=user.major.name]').setValue(record.get('major.id') + '-' + record.get('major.name'));
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
	memberFP.down('[name=user.avatar]').setValue(record.get('avatar'));
	if(record.get('avatar') != null && record.get('avatar') != ''){
		memberFP.down('image').setSrc('uploads/' + record.get('avatar'));
	}
	if(record.get('birthday') != null && record.get('birthday') != '')
		memberFP.down('[name=user.birthday]').setValue(new Date(Date.parse(record.get('birthday').replace(/\./g,"/"))));
	if(record.get('graduateTime') != null && record.get('graduateTime') != '')
		memberFP.down('[name=user.graduateTime]').setValue(new Date(Date.parse(record.get('graduateTime').replace(/\./g,"/"))));
	//加载好combobox数据并设置初始值
	Ext.data.StoreManager.lookup('InstitutionStore').load({
		callback : function(records, operation, success){
			memberFP.form.findField('institution.id').setValue(record.get('institution.id'));
		}
	});
	Ext.data.StoreManager.lookup('DegreeStore').load({
		callback : function(records, operation, success){
			memberFP.form.findField('degree.id').setValue(record.get('degree.id'));
		}
	});
	Ext.data.StoreManager.lookup('EducationStore').load({
		callback : function(records, operation, success){
			memberFP.form.findField('education.id').setValue(record.get('education.id'));
		}
	});
	modifyMemberWindow.show();
};
//修改用户
var modifyMember = function(memberFP, store){
	if(memberFP.form.isValid()){
		memberFP.form.submit({
			url : 'manager/modifyMember.action',
			timeout : 5000,
			method : 'POST',
			success : function(){
				store.load();
				Ext.Msg.alert('信息', '修改成功...');
			}
		});
	}else{
		Ext.Msg.alert('信息', '请正确填写信息...');
	}
};
//会员搜索
var searchMember = function(searchFP){
	Ext.data.StoreManager.lookup('UserStore').load({
		params : {
			'conditionDTO.degree' : searchFP.down('[name=conditionDTO.degree]').getValue(),
			'conditionDTO.education' : searchFP.down('[name=conditionDTO.education]').getValue(),
			'conditionDTO.institution' : searchFP.down('[name=conditionDTO.institution]').getValue(),
			'conditionDTO.title' : searchFP.down('[name=conditionDTO.title]').getValue(),
			'conditionDTO.adept' : searchFP.down('[name=conditionDTO.adept]').getValue(),
			'conditionDTO.currentMajor' : searchFP.down('[name=conditionDTO.currentMajor]').getValue(),
		}
	});
};