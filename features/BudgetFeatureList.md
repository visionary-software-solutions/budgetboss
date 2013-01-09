<table>
	<thead>
		<tr>
		 	<th>Feature</th>
		 	<th>Story</th>
		 	<th>Status</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>Budgets have names</td>
		  	<td>
		   	<ul>
		      		<li>Given: A budget is to be created</li>
		       		<li>When: The budget is constructed with a String input</li>
		      		<li>Then: That String becomes the budget name</li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>Budgets names serve as filenames</td>
		  	<td>
		   	<ul>
		      		<li>Given: A budget is to be saved</li>
		       		<li>When: A filename is required</li>
		      		<li>Then: The budget filename is derived from the the budget's name</li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>Budgets have start/end dates</td>
		  	<td>
		   	<ul>
		      		<li>Given: A budget is to be created</li>
		       		<li>When: It is instantiated</li>
		      		<li>Then: The budget will have fields for start and end date</li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>Budgets dates are null until set</td>
		  	<td>
		   	<ul>
		      		<li>Given: A budget is created</li>
		       		<li>When: The user has not yet edited the start/end dates</li>
		      		<li>Then: Those fields will be null, and if asked to display will instead show a message indicating they need to be set</li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
	</tbody>
	<tfoot>
	</tfoot>
</table>