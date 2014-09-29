/**
 * 显示或隐藏用户管理面板
 */
var showMembers = function(record, mainPanel, MembersGP, store){
	if(record.get('id')=='memberManage'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(MembersGP).doLayout();
		MembersGP.show();
		store.load({
			params : {
				start : 0,
				page : 1,
				limit : 15
			}
		});
	} else {
		MembersGP.hide();
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
			url : 'manager/addThesis.action?userId=' + userId,
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
			url : 'manager/addPatent.action?userId=' + userId,
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
			url : 'manager/addProject.action?userId=' + userId,
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
			url : 'manager/addAward.action?userId=' + userId,
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