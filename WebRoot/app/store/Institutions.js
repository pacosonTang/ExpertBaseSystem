Ext.create("Ext.data.Store", {
	model : 'Institution',
	storeId : 'InstitutionStore',
	proxy : {
		type : 'ajax',
		url : 'common/showInstitutions.action',
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