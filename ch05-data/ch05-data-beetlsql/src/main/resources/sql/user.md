selectSample
===

* 一个简单的查询例子
* 根据用户名查询用户
	select * from user where 1=1
	@if(!isEmpty(name)){
	and name = #name#
	@}
	