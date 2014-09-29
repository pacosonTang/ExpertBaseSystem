Ext.create("Ext.data.Store", {
	model : 'Degree',
	storeId : 'DegreeStore',
	proxy : {
		type : 'ajax',
		url : 'common/showDegrees.action',
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