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
			<td>InputValidator can validate for integers</td>
		  	<td>
		   	<ul>
		      		<li>Given: BudgetBoss is running and requires an integer input</li>
		       		<li>When: The user inputs anything other than an integer</li>
		      		<li>Then: An error message is generated and the user is prompted again for input</li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>InputValidator can validate paths - Linux</td>
		  	<td>
		   	<ul>
		      		<li>Given: BudgetBoss is running and requires a path input</li>
		       		<li>When: The user inputs anything other than a valid, existing Linux path</li>
		      		<li>Then: An appropriate error message is generated based on the likely problem with the path and the user is prompted again for input</li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>InputValidator can validate budget selection when loading from a directory</td>
		  	<td>
		   	<ul>
		      		<li>Given: BudgetBoss has searched for budgets in a directory and is displaying the list of found budgets</li>
		       		<li>When: The user inputs anything other than an integer corresponding with the printed list of budgets</li>
		      		<li>Then: An error message is generated and the user is prompted again for input</li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>InputValidator can validate menu selections</td>
		  	<td>
		   	<ul>
		      		<li>Given: BudgetBoss is displaying a numbered menu and waiting for input</li>
		       		<li>When: The user inputs anything other than an integer corresponding with the printed list of menu options</li>
		      		<li>Then: An error message is generated and the user is prompted again for input</li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
		<tr>
			<td>InputValidator can validate date inputs</td>
		  	<td>
		   	<ul>
		      		<li>Given: Budgetboss is running and requires a date input (format: MM/DD/YYYY)</li>
		       		<li>When: The user inputs anything other than an a valid date (Month 1-12, corresponding correct number of days, and no years from the past) in the above format</li>
		      		<li>Then: An appropriate error message is generated based on the likely problem with the date and the user is prompted again for input</li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
<tr>
			<td>InputValidator can recognize global exit command</td>
		  	<td>
		   	<ul>
		      		<li>Given: BudgetBoss is waiting for input</li>
		       		<li>When: The user inputs "exit" regardless of case</li>
		      		<li>Then: InputValidator reports this as a valid input, allowing the program to continue and subsequently exit</li>
		 	</td>
		 	<td>Implemented</td>
		</tr>
	</tbody>
	<tfoot>
	</tfoot>
</table>