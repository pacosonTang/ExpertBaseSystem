Ext.define("Thesis", {
	extend : 'Ext.data.Model',
	fields : [
		{name : 'id',type:'int',sortable:true},
		{name : 'name',type:'string',sortable:true},
		{name : 'pubTime',type:'string',sortable:true}
	]
});