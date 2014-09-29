Ext.create("Ext.data.Store", {
	model : 'Degree',
	storeId : 'EducationStore',
	proxy : {
		type : 'ajax',
		url : 'common/showEducations.action',
		reader : {
			type : 'json',
			root : 'list',
			successProperty : '@success',
			totalProperty : 'totalCount'
		},
		writer : {
			type : 'json'
		}
	}
});