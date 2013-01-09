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
		       		<li>For more on available main menu features see: <a href = "MainMenuFeatureList.md">Main Menu Feature List</a>
		 	</td>
		  	<td>Implemented</td>
		</tr>
		<tr>
			<td>BudgetBoss can create new budgets</td>
		  	<td>
		   	<ul>
		      		<li>Given: BudgetBoss is running</li>
		       		<li>When: A user needs to create a new budget</li>
		      		<li>Then: The user will be prompted to name the budget, and it will be created and set as the budget in use</li>
				<li>For more on the features of the budgets themselves, see: <a href = "BudgetFeatureList.md">Budget Feature List</a></li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>BudgetBoss can save budgets to disk</td>
		  	<td>
		   	<ul>
		      		<li>Given: BudgetBoss is running and a budget is in use</li>
		       		<li>When: A user needs to store a budget outside of the program</li>
		      		<li>Then: The user can write the budget to disk as a .bgt file</li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>BudgetBoss can load saved budgets</td>
		  	<td>
		   	<ul>
		      		<li>Given: BudgetBoss is running</li>
		       		<li>When: A user needs to access a previously saved budget</li>
		      		<li>Then: The user can open the desired budget and it will load into BudgetBoss</li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>BudgetBoss can seach for budgets to load</td>
		  	<td>
		   	<ul>
		      		<li>Given: BudgetBoss is running</li>
		       		<li>When: A user needs to access a previously saved budget</li>
		      		<li>Then: The user can point BudgetBoss to a valid path and it will collect any saved budgets there for potential loading</li>
				<li>For more on how the validity of the path is determined, see: <a href = "InputValidatorFeatureList.md">Input Validator Feature List</a></li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>BudgetBoss can load budgets from a selectable list</td>
		  	<td>
		   	<ul>
		      		<li>Given: BudgetBoss has collected saved budgets from a directory searched</li>
		       		<li>When: A user wants to open a collected budgets</li>
		      		<li>Then: The budgets names will be printed and paired with indicator numbers, allowing the user to input the number of the budget they want to open</li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>BudgetBoss can generate budget reports</td>
		  	<td>
		   	<ul>
		      		<li>Given: BudgetBoss is running</li>
		       		<li>When: A user needs to see a summary of all the information in a budget</li>
		      		<li>Then: The user can print out the contents of the budget via the budget's toString() method, to the console</li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>BudgetBoss can save budget reports to disk</td>
		  	<td>
		   	<ul>
		      		<li>Given: BudgetBoss is running</li>
		       		<li>When: A user needs to see a summary of all the information in a budget</li>
				<li>And: Have access to that information outside of BudgetBoss
		      		<li>Then: The user can print out the contents of the budget via the budget's toString() method, to a text document</li>
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
		       		<li>When: The main menu comes up initially, before a user has a chance to open/create a budget</li>
		       		<li>Then: The indicator for the budget in use will show "No budget loaded"</li>
				<li>And: Menu features will be restricted until a budget is opened/created.</li>
		       		<li>For more on restricting menu functions see: <a href = "MainMenuFeatureList.md">Main Menu Feature List</a></li>

		 	</td>
		  	<td>Implemented</td>
		</tr>
		<tr>
			<td>BudgetBoss has a default load directory - Linux</td>
		  	<td>
		   	<ul>
		      		<li>Given: BudgetBoss is running</li>
		       		<li>When: A user is loading a budget after initial program launch</li>
		      		<li>Then: The user will be given the option, via inputting "y", to search their Documents directory for budgets, which is the program default(i.e. /home/nathan/Documents/)</li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>BudgetBoss has a default save directory - Linux</td>
		  	<td>
		   	<ul>
		      		<li>Given: BudgetBoss is running</li>
		       		<li>When: A user is saving a budget/budget report after loading/creating one</li>
		      		<li>Then: The user will be given the option, via inputting "y", to save to the budget to their Documents directory, which is the program default(i.e. /home/nathan/Documents/)</li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>BudgetBoss modifies default load directory</td>
		  	<td>
		   	<ul>
		      		<li>Given: BudgetBoss is running</li>
		       		<li>When: A user is loading a budget after initial program launch</li>
				<li>And: The user declines to use the default directory, and instead opts to input a custom load directory path</li>
		      		<li>If: The user enters a valid path and successfully loads a budget from it</li>
				<li>Then: BudgetBoss will make the directory from which the budget was loaded the new default load directory</li>
				<li>For more on how the validity of the inputted path is determined, see: <a href = "InputValidatorFeatureList.md">Input Validator Feature List</a></li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>BudgetBoss modifies default save directory</td>
		  	<td>
		   	<ul>
		      		<li>Given: BudgetBoss is running</li>
		       		<li>When: A user is saving a budget/budget report</li>
				<li>And: The user declines to use the default directory, and instead opts to input a custom save directory path</li>
		      		<li>If: The user enters a valid path and successfully saves a budget</li>
				<li>Then: BudgetBoss will make the directory to which the budget was saved the new default save directory</li>
				<li>For more on how the validity of the inputted path is determined, see: <a href = "InputValidatorFeatureList.md">Input Validator Feature List</a></li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>BudgetBoss shares same default directory for saving/loading</td>
		  	<td>
		   	<ul>
		      		<li>Given: BudgetBoss is running</li>
		       		<li>When: A user is loading/saving a budget/budget report</li>
		      		<li>Then: The default directory they are prompted with will be the last place a budget was saved/loaded from as both saving and loading share the same changeable default directory and either process can modify it</li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>BudgetBoss clears console output on launch and when displaying menus</td>
		  	<td>
		   	<ul>
		      		<li>Given: Personal finances need to be managed in a boss-like fashion</li>
		       		<li>When: BudgetBoss is launched</li>
				<li>And: When any menu is displayed
		      		<li>Then: The console output is cleared allowing the menus to remain more or less fixed, for a more pleasant user experience</li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>BudgetBoss can edit budget name</td>
		  	<td>
		   	<ul>
		      		<li>Given: A budget is in use with BudgetBoss</li>
		       		<li>When: A user wants to change the name of the budget in use</li>
		      		<li>Then: A new name can be set for the budget, provided it is not "exit" (regardless of case, as that command works anywhere BudgetBoss takes input)</li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>BudgetBoss can edit budget dates</td>
		  	<td>
		   	<ul>
		      		<li>Given: A budget is in use with BudgetBoss</li>
		       		<li>When: A user wants to change the start/end date of the budget in use</li>
		      		<li>Then: New dates can be set for the budget, provided they are valid</li>
				<li>For more on how the validity of the date is determined, see: <a href = "InputValidatorFeatureList.md">InputValidator Feature List</a></li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
		  	<td>BudgetBoss has a global exit command</td>
		  	<td>
		    	<ul>
		       		<li>Given: BudgetBoss is running</li>
		       		<li>When: A user wants to exit the program </li>
				<li>And: Is able to provide input to BudgetBoss</li>
		       		<li>Then: Providing "exit" as an input regardless of case will indeed exit the program</li>
		 	</td>
		  	<td>Implemented</td>
		</tr>
	</tbody>
	<tfoot>
	</tfoot>
</table>