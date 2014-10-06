Ext.define("Subject", {
	extend : 'Ext.data.Model',
	fields :[
		{name : 'id', type : 'int', sortable : true},
		{name : 'name', type : 'string', sortable : true},
		{name : 'parent.id', type : 'int', sortable : true},
		{name : 'parent.name', type : 'string', sortable : true}
	]
});