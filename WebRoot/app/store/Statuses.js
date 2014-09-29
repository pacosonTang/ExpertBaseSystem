Ext.create("Ext.data.Store", {
	model : 'Status',
	storeId : 'StatusStore',
	data : [
	    {id : '0', name : '已验收'},
	    {id : '1', name : '完成未验收'},
	    {id : '2', name : '在研'}
	]
});