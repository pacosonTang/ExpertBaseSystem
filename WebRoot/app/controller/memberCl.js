//显示或隐藏修改用户信息面板
var showMe = function(record, mainPanel, showUser){
	if(record.get('id')=='myInfo'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(showUser).doLayout();
		showUser.form.load({
			url : 'common/showUser.action',
			method : 'POST',
			waitMsg : '数据正在加载...',
			waitTitle : '请稍后',
			timeout : 10000,
			success : function(form, action){
				var json = Ext.JSON.decode(action.response.responseText);
				var data = json['list'][0];
				var date = data['birthday'];
				var transDate = new Date(Date.parse(date.replace(/\./g,"/")));
				showUser.form.findField('birthday').setValue(transDate);
				date = data['graduateTime'];
				transDate = new Date(Date.parse(date.replace(/\./g, "/")));
				showUser.form.findField('graduateTime').setValue(transDate);
				showUser.down('[name=user.major.name]').setValue(data['major']['id'] + '-' + data['major']['name']);
				//加载好combobox数据并设置初始值
				Ext.data.StoreManager.lookup('InstitutionStore').load({
					callback : function(records, operation, success){
						showUser.form.findField('institution.id').setValue(data['institution']['id']);
					}
				});
				Ext.data.StoreManager.lookup('DegreeStore').load({
					callback : function(records, operation, success){
						showUser.form.findField('degree.id').setValue(data['degree']['id']);
					}
				});
				Ext.data.StoreManager.lookup('EducationStore').load({
					callback : function(records, operation, success){
						showUser.form.findField('education.id').setValue(data['education']['id']);
					}
				});
				if(data['avatar'] != null && data['avatar'] != '')
					showUser.down('[name=user.avatar]').setSrc('uploads/' + data['avatar']);
			},
			failure : function(form, action){
				Ext.Msg.alert('信息', '数据加载失败！');
			}
		});
		showUser.show();
	} else {
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
 * 显示论文
 */
var showThesises = function(record, mainPanel, thesisesGP, store){
	if(record.get('id')=='thesisManage'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(thesisesGP).doLayout();
		store.load({
			params : {
				userId : userId
			}
		});
		thesisesGP.show();
	} else {
		thesisesGP.hide();
	}
};
/**
 * 显示专利
 */
var showPatents = function(record, mainPanel, patentsGP, store){
	if(record.get('id')=='patentManage'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(patentsGP).doLayout();
		store.load({
			params : {
				userId : userId
			}
		});
		patentsGP.show();
	} else {
		patentsGP.hide();
	}
};
/**
 * 显示项目
 */
var showProjects = function(record, mainPanel, projectsGP, store){
	if(record.get('id')=='projectManage'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(projectsGP).doLayout();
		store.load({
			params : {
				userId : userId
			}
		});
		projectsGP.show();
	} else {
		projectsGP.hide();
	}
};
/**
 * 显示项目
 */
var showAwards = function(record, mainPanel, awardsGP, store){
	if(record.get('id')=='awardManage'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(awardsGP).doLayout();
		store.load({
			params : {
				userId : userId
			}
		});
		awardsGP.show();
	} else {
		awardsGP.hide();
	}
};
/**
 * 修改自己的信息
 */
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
//添加论文
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
//删除论文
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
//删除专利
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
//添加专利
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
//添加项目
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
//删除项目
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
//添加奖励
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
//删除奖励
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
//上传图片
var savaImg = function(imgFP, userFP, userId){
	if(imgFP.form.isValid()){
		imgFP.form.submit({
			url : 'member/upload.action?userId=' + userId,
			success : function(form, action){
				userFP.down('image').setSrc('uploads/' + action.result.imgName);
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