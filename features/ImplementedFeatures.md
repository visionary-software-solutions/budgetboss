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
		  <td>Get Budget at program launch</td>
		  <td>
		    <ul>
		       <li>Given: An instance of BudgetBoss</li>
		       <li>When: The program starts up</li>
		       <li>Then: BudgetBoss will ask to load a Budget</li>
		       <li>And: If the user declines, it will prompt to create a Budget</li>
		  </td>
		  <td>Implemented</td>
		</tr>
		<tr>
		  <td>BudgetBoss can create Budgets</td>
		  <td>
		    <ul>
		       <li>Given: An instance of BudgetBoss</li>
		       <li>When: A a new Budget is desired</li>
		       <li>Then: A new Budget can be created and used in BudgetBoss</li>
		  </td>
	 	  <td>Implemented</td>
		</tr>
		<tr>
		  <td>Budgets have user-definable names</td>
		  <td>
		    <ul>
		       <li>Given: An instance of BudgetBoss</li>
		       <li>When: A a new Budget is created</li>
		       <li>Then: The user will be asked to input a name for the Budget, this will be the filename and how it is shown when being accessed through a directory search</li>
		  </td>
	 	  <td>Implemented</td>
		</tr>
		<tr>
		  <td>BudgetBoss can save Budgets</td>
		  <td>
		    <ul>
		       <li>Given: A Budget is created with BudgetBoss</li>
		       <li>When: The user wants to save the Budget for later use/access</li>
		       <li>Then: BudgetBoss can save the budget to disk</li>
		  </td>
	 	  <td>Implemented</td>
		</tr>
		<tr>
		  <td>BudgetBoss can load Budgets</td>
		  <td>
		    <ul>
		       <li>Given: An instance of BudgetBoss</li>
		       <li>When: The user wants to open a Budget rather than create one</li>
		       <li>Then: BudgetBoss can open/load a previously saved Budget for use/access</li>
		  </td>
	 	  <td>Implemented</td>
		</tr>
		<tr>
		  <td>Budgets have start and end dates</td>
		  <td>
		    <ul>
		       <li>Given: A Budget is created with BudgetBoss</li>
		       <li>When: The Budget is generated</li>
		       <li>Then: It will have start and end date fields, denoting the period of time for which the Budget is intended to be used</li>
		  </td>
	 	  <td>Implemented</td>
		</tr>
		<tr>
		  <td>Budgets dates are retrievable and user-definable</td>
		  <td>
		    <ul>
		       <li>Given: A Budget is created with BudgetBoss</li>
		       <li>And: A user wants to access/change the dates of the Budget</li>
		       <li>When: The user wants to view the dates</li>
		       <li>Then: The dates will print</li>
		       <li>And When: The user wants to change a/the date(s)<li>
		       <li>Then: The desired date(s) can be defined by the user<li>
		  </td>
	 	  <td>Implemented</td>
		</tr>
		<tr>
		  <td>BudgetBoss has a default initial save/load directory - Linux</td>
		  <td>
		    <ul>
		       <li>Given: An instance of BudgetBoss</li>
		       <li>When: The user wants to open/save a Budget</li>
		       <li>Then: BudgetBoss will offer to use /home/(username)/Documents/</li>
		  </td>
	 	  <td>Implemented</td>
		</tr>
	</tbody>
	<tfoot>
	</tfoot>
</table>