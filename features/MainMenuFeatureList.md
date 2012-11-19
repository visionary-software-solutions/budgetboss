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
				<li>For more on how the validity of the input is determined, see: <a href = "InputValidatorFeatureList.md">Input Validator Feature List</a></li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>Main menu displays error messages below numbered option list</td>
		  	<td>
		   	<ul>
		      		<li>Given: An attempt was made to select a main menu option</li>
		       		<li>When: The input received to indicate selection is invalid</li>
		      		<li>Then: An appropriate error message indicating the problem with the input will be printed at the bottom of the numbered list of options</li>
				<li>And: The user will be able to offer input again</li>
				<li>For more on how the validity of the input is determined, see: <a href = "InputValidatorFeatureList.md">Input Validator Feature List</a></li>
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
				<li>For more on budget reports, see: <a href = "BudgetBossFeatureList.md">BudgetBoss Feature List</a></li>
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
				<li>For more on how saving works in BudgetBoss or budget reports, see: <a href = "BudgetBossFeatureList.md">BudgetBoss Feature List</a></li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>Main menu has the option to start editing the budget in use</td>
		  	<td>
		   	<ul>
		      		<li>Given: The main menu of BudgetBoss is displayed and a budget is in use</li>
		       		<li>When: A user wants to edit any aspect of the budget</li>
		      		<li>Then: "Edit budget" will be an option on the menu</li>
				<li>And: Upon selecting this option, the editor menu will appear, as if by magic</li>
				<li>For more on the features of the editor menu, see: <a href = "EditorMenuFeatureList.md">Editor Menu Feature List</a></li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>Main menu has the option to save a budget to disk</td>
		  	<td>
		   	<ul>
		      		<li>Given: The main menu of BudgetBoss is displayed</li>
		       		<li>When: A user wants to save a budget for future access</li>
		      		<li>Then: "Save budget" will be an option on the menu</li>
				<li>And: Upon selecting this option, the budget will be saved to a directory of the user's choosing as a .bgt file</li>
				<li>For more on how saving works in BudgetBoss, see: <a href = "BudgetBossFeatureList.md">BudgetBoss Feature List</a></li>
			</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>Main menu has the option to load a budget from disk</td>
		  	<td>
		   	<ul>
		      		<li>Given: The main menu of BudgetBoss is displayed</li>
		       		<li>When: A user wants to load a previously saved budget</li>
		      		<li>Then: "Load budget" will be an option on the menu</li>
				<li>And: Upon selecting this option, a budget will be loaded from a directory of the user's choosing</li>
				<li>For more on how loading works in BudgetBoss, see: <a href = "BudgetBossFeatureList.md">BudgetBoss Feature List</a></li>
			</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>Main menu has the option to create a new budget</td>
		  	<td>
		   	<ul>
		      		<li>Given: The main menu of BudgetBoss is displayed</li>
		       		<li>When: A user wants to create a new budget</li>
		      		<li>Then: "Create a new budget" will be an option on the menu</li>
				<li>And: Upon selecting this option, a new budget will be created with a user-supplied name and set as the budget in use</li>
				<li>For more on how creating budgets works in BudgetBoss, see: <a href = "BudgetBossFeatureList.md">BudgetBoss Feature List</a></li>
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
				
				<li>And: Upon selecting this option, BudgetBoss will exit</a></li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
	</tbody>
	<tfoot>
	</tfoot>
</table>