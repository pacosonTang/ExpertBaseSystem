Ext.define("Patent", {
	extend : 'Ext.data.Model',
	fields : [
		{name : 'id',type:'int',sortable:true},
		{name : 'name',type:'string',sortable:true},
		{name : 'authorityTime',type:'string',sortable:true},
		{name : 'patentNo',type:'string',sortable:true}
	]
});