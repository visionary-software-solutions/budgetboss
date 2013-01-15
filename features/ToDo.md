I have yet to find a budget application that works the way I want it to, so I am going to make one. The goal of this is to be supremely flexible, but I'm definitely going to be focusing on the paycheck-to-paycheck crowd initially with the features.

To-Do List : BudgetBoss
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
		  <td>Listener can take a String input from console or text file and return it for use (via depency injection)</td>
		  <td>
		    <ul>
			   <li>Story: When it is necessary for a  program to receive external input, Listener can provide it</li>
			   <li>Given: A Listener is needed to take input</li>
		       <li>When: Input is provided</li>
		       <li>Then: Listener will use a reader to take the input</li>
		  </td>
	 	  <td>Currently working on this</td>
		</tr>
		<tr>
		  <td>BudgetBoss has a default initial save/load directory - Windows</td>
		  <td>
		    <ul>
		       <li>Given: An instance of BudgetBoss</li>
		       <li>When: The user wants to open/save a Budget</li>
		       <li>Then: BudgetBoss will offer to use C:\Users\(username)\Documents\</li>
		  </td>
	 	  <td>Not yet implemented</td>
		</tr>
		<tr>
		  <td>BudgetBoss can detect host OS and current username for default path generation</td>
		  <td>
		    <ul>
		       <li>Given: An instance of BudgetBoss</li>
		       <li>And: The user wants to open/save a Budget</li>
		       <li>When: The default path is to be offered</li>
		       <li>Then: BudgetBoss will generate the correct path by detecting username and host OS</li>
		  </td>
	 	  <td>Partially implemented - It can get the username at this point</td>
		</tr>
		<tr>
		  <td>BudgetBoss has a user-definable save/load directory</td>
		  <td>
		    <ul>
		       <li>Given: An instance of BudgetBoss</li>
		       <li>When: A budget needs to be saved/loaded</li>
		       <li>And: The user declines to use the default directory</li>
		       <li>Then: The user can define a custom directory, provided it is an existing/valid path</li>
		  </td>
	 	  <td>Partially implemented...only will work on Linux boxes at the moment</td>
		</tr>
		<tr>
		  <td>BudgetBoss validates user inputs</td>
		  <td>
		    <ul>
		       <li>Given: An instance of BudgetBoss</li>
		       <li>And: Input is required/requested from the user</li>
		       <li>When: The user provides the input</li>
		       <li>Then: BudgetBoss will make sure it meets a set of conditions making it a valid input for whatever purpose the input was required/requested for</li>
		  </td>
	 	  <td>Partially implemented - not all checks in place, yet</td>
		</tr>
		<tr>
		  <td>BudgetBoss has a mode/menu for editing Budgets</td>
		  <td>
		    <ul>
		       <li>Given: An instance of BudgetBoss</li>
		       <li>When: A Budget is either created or opened</li>
		       <li>Then: If desired, the user can access an Editor Menu</li>
		       <li>And: From there, make changes to any/all aspects of the Budget (specific editing features listed seperately)</li>
		  </td>
	 	  <td>Partially implemented - BudgetEditor exists, but is very sparse</td>
		</tr>
		<tr>
		  <td>Budgets have default spending categories to add</td>
		  <td>
		    <ul>
		       <li>Given: An instance of BudgetBoss</li>
		       <li>When: A new Budget is created</li>
		       <li>Then: The Budget will have some built in spending categories to choose from</li>
		       <li>And: The user can choose from the categories and add them to the Budget as desired</li>
		  </td>
	 	  <td>Not yet implemented</td>
		</tr>
		<tr>
		  <td>BudgetBoss budgets can be integrated with Budginator</td>
		  <td>
		    <ul>
		       <li>Given: A Budget created by BudgetBoss</li>
		       <li>When: That Budget is to be used with Budginator</li>
		       <li>Then: The Budget will conform to the MasterBudget Interface</li>
		       <li>And: The Budget can be converted into JSON format</li>
		  </td>
	 	  <td>Partially implemented - initial BudgetToJSON class in place</td>
		</tr>
		</tbody>
	<tfoot>
	</tfoot>
</table>
