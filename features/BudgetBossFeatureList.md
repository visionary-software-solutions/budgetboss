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
		  	<td>BudgetBoss has a main menu</td>
		  	<td>
		    	<ul>
		       		<li>Given: Personal finances need to be managed in a boss-like fashion</li>
		       		<li>When: BudgetBoss is launched</li>
		       		<li>And: After an initial welcome message</li>
		       		<li>Then: A main menu will appear with access to various functions</li>
		       		<li>For more on available main menu features see: <a href = "BudgetBoss/features/MainMenuFeatureList.md">Main Menu Feature List</a>
		 	</td>
		  	<td>Implemented</td>
		</tr>
		<tr>
		  	<td>BudgetBoss indicates budget in use</td>
		  	<td>
		    	<ul>
		       		<li>Given: BudgetBoss is launched</li>
		       		<li>When: A saved budget is opened or a budget is created</li>
		       		<li>Then: An indicator above the menus will show the name of the current budget in use</li>
		 	</td>
		  	<td>Implemented</td>
		</tr>
		<tr>
		  	<td>BudgetBoss knows when there is no budget in use</td>
		  	<td>
		    	<ul>
		       		<li>Given: BudgetBoss is launched</li>
		       		<li>When: The main menu comes up initially, before the user has a chance to open/create a budget</li>
		       		<li>Then: The indicator for the budget in use will show "No budget loaded"</li>
				<li>And: Menu features will be restricted until a budget is opened/created.</li>
		       		<li>For more on restricting menu functions see: <a href = "BudgetBoss/features/MainMenuFeatureList.md">Main Menu Feature List</a>

		 	</td>
		  	<td>Implemented</td>
		</tr>
		<tr>
		  	<td>BudgetBoss has a global exit command</td>
		  	<td>
		    	<ul>
		       		<li>Given: BudgetBoss is launched</li>
		       		<li>When: A saved budget is opened or a budget is created</li>
		       		<li>Then: An indicator above the menus will show the name of the current budget in use</li>
		 	</td>
		  	<td>Implemented</td>
		</tr>
	</tbody>
	<tfoot>
	</tfoot>
</table>