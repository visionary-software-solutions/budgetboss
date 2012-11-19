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
			<td>Editor menu presents options in a numbered list</td>
		  	<td>
		   	<ul>
		      		<li>Given: The editor is started in BudgetBoss</li>
		       		<li>When: The options available on the editor menu need to presented to a user</li>
		      		<li>Then: The options are printed out with numerical identifiers and a brief description</li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>Editor menu takes integer input to select from options</td>
		  	<td>
		   	<ul>
		      		<li>Given: The editor menu is displayed and a user wants to select a option</li>
		       		<li>When: The user inputs a valid number corresponding with a visible option</li>
		      		<li>Then: The associated action of the selected option is carried out</li>
				<li>For more on how the validity of the input is determined, see: <a href = "InputValidatorFeatureList.md">Input Validator Feature List</a></li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>Editor menu displays error messages below numbered option list</td>
		  	<td>
		   	<ul>
		      		<li>Given: An attempt was made to select an editor menu option</li>
		       		<li>When: The input received to indicate selection is invalid</li>
		      		<li>Then: An appropriate error message indicating the problem with the input will be printed at the bottom of the numbered list of options</li>
				<li>And: The user will be able to offer input again</li>
				<li>For more on how the validity of the input is determined, see: <a href = "InputValidatorFeatureList.md">Input Validator Feature List</a></li>
			</td>
		 	<td>Implemented</td>
		</tr>
<tr>
			<td>Editor menu has the option to print a budget report to the console</td>
		  	<td>
		   	<ul>
		      		<li>Given: The editor menu of BudgetBoss is displayed</li>
		       		<li>When: A user wants to generate a budget report to the console</li>
		      		<li>Then: "Print budget report to console" will be an option on the menu</li>
				<li>And: Upon selecting this option, the budget report prints to the console</li>
				<li>For more on budget reports, see: <a href = "BudgetBossFeatureList.md">BudgetBoss Feature List</a></li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>Editor menu has the option to save a budget report to disk</td>
		  	<td>
		   	<ul>
		      		<li>Given: The editor menu of BudgetBoss is displayed</li>
		       		<li>When: A user wants to generate a budget report and save it for future access</li>
		      		<li>Then: "Save a budget report" will be an option on the menu</li>
				<li>And: Upon selecting this option, a budget report will be generated and saved to a directory of the user's choosing, as a text file</li>
				<li>For more on how saving works in BudgetBoss or budget reports, see: <a href = "BudgetBossFeatureList.md">BudgetBoss Feature List</a></li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>Editor menu has the option edit budget name</td>
		  	<td>
		   	<ul>
		      		<li>Given: The editor menu of BudgetBoss is displayed</li>
		       		<li>When: A user wants to change the name of the budget in use</li>
		      		<li>Then: "Edit budget name" will be an option on the menu</li>
				<li>And: Upon selecting this option, a new name for the budget can be inputted</li>
				<li>For more on editing the budget name, see: <a href = "BudgetBossFeatureList.md">BudgetBoss Feature List</a></li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>Editor menu has the option edit budget dates</td>
		  	<td>
		   	<ul>
		      		<li>Given: The editor menu of BudgetBoss is displayed</li>
		       		<li>When: A user wants to change the start/end date of the budget in use</li>
		      		<li>Then: "Edit budget start date" and "Edit budget end date" will be options on the menu, respectively</li>
				<li>And: Upon selecting either option, a new date can be inputted</li>
				<li>For more on editing the budget dates, see: <a href = "BudgetBossFeatureList.md">BudgetBoss Feature List</a></li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>Editor menu has the option to return to main menu</td>
		  	<td>
		   	<ul>
		      		<li>Given: The editor menu of BudgetBoss is displayed</li>
		       		<li>When: A user wants to stop editing the budget in use and have access to the main menu options</li>
		      		<li>Then: "Return to main menu" will be an option on the menu</li>
				<li>And: Upon selecting this option, BudgetBoss will display the main menu</a></li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
	</tbody>
	<tfoot>
	</tfoot>
</table>