Ext.create("Ext.data.Store", {
	model : 'Subject',
	storeId : 'SubjectStore',
	proxy : {
		type : 'ajax',
		url : 'manager/showAllSubjects.action',
		reader : {
			type : 'json',
			root : 'list',
			successProperty : '@success',
			totalProperty : 'totalCount'
		},
		actionMethod : {read : 'POST'}
	}
});