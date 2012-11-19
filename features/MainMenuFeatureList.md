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
			<td>Main menu presents options in a numbered list</td>
		  	<td>
		   	<ul>
		      		<li>Given: BudgetBoss is launched</li>
		       		<li>When: The options available on the main menu need to presented to a user</li>
		      		<li>Then: The options are printed out with numerical identifiers and a brief description</li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>Main menu takes integer input to select from options</td>
		  	<td>
		   	<ul>
		      		<li>Given: The main menu is displayed and a user wants to select a option</li>
		       		<li>When: The user inputs a valid number corresponding with a visible option</li>
		      		<li>Then: The associated action of the selected option is carried out</li>
				<li>For more on how the validity of the input is determined, see: <a href = "BudgetBoss/features/InputValidatorFeatureList.md">Input Validator Feature List</a>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>Main menu restricts selectable options until a budget is in use</td>
		  	<td>
		   	<ul>
		      		<li>Given: BudgetBoss is launched</li>
		       		<li>When: A user is prompted with the initial main menu</li>
		      		<li>Then: The only options that are able to be chosen are open/create a budget, or to exit</li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>Main menu has the option to print a budget report to the console</td>
		  	<td>
		   	<ul>
		      		<li>Given: The main menu of BudgetBoss is displayed</li>
		       		<li>When: A user wants to generate a budget report to the console</li>
		      		<li>Then: "Print budget report to console" will be an option on the menu</li>
				<li>And: Upon selecting this option, the budget report prints to the console</li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>Main menu has the option to save a budget report to disk</td>
		  	<td>
		   	<ul>
		      		<li>Given: The main menu of BudgetBoss is displayed</li>
		       		<li>When: A user wants to generate a budget report and save it for future access</li>
		      		<li>Then: "Save a budget report" will be an option on the menu</li>
				<li>And: Upon selecting this option, a budget report will be generated and saved to a directory of the user's choosing, as a text file</li>
				<li>For more on how saving works in BudgetBoss, see: <a href = "BudgetBoss/features/BudgetBossFeatureList.md">BudgetBoss Feature List</a>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>Main menu has the option to exit BudgetBoss</td>
		  	<td>
		   	<ul>
		      		<li>Given: The main menu of BudgetBoss is displayed</li>
		       		<li>When: A user wants to exit the program </li>
		      		<li>Then: Exit BudgetBoss will be an option on the menu</li>
				<li>And: Upon selecting this option, the program will subsequently exit</li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
	</tbody>
	<tfoot>
	</tfoot>
</table>