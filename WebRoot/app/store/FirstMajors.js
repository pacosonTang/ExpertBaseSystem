Ext.create("Ext.data.Store", {
	model : 'Major',
	storeId : 'FirstMajorStore',
	proxy : {
		type : 'ajax',
		url : 'common/showSubjects.action?subjectId=0',
		reader : {
			type : 'json',
			root : 'list',
			successProperty : '@success',
			totalProperty : 'totalCount'
		},
		actionMethod : {read : 'POST'},
		autoLoad : true
	}
});