# Marija Dimitrovska 145049
TASK 2:
Explanation of CFG:

START: Entry point of the function.
A: Checks if the user or any of its properties are null. If true, throws a RuntimeException.
B: Checks if the username is null. If true, sets the username as the email.
C: Performs a loop over all existing users to check for email and username duplicates. Increments same if a duplicate is found.
D: Checks if the password contains the username (case-insensitive) or its length is less than 8. If true, returns false.
E: Checks if the password doesn't contain any spaces and contains at least one special character. If true, returns the value of same == 0.
END: Exit point of the function.

TASK 3:
The first decision point is the if statement if (user==null || user.getPassword()==null || user.getEmail()==null). This creates two paths: one when the condition is true and an exception is thrown, and another when the condition is false.
The second decision point is the if statement if (user.getUsername()==null). This creates two paths: one when the condition is true and the username is set, and another when the condition is false.
The third decision point is the if statement if (user.getEmail().contains("@") && user.getEmail().contains(".")). This creates two paths: one when the condition is true, and the loop is executed, and another when the condition is false.
Inside the loop, there are two more decision points: the if statements if (existingUser.getEmail() == user.getEmail()) and if (existingUser.getUsername() == user.getUsername()). Each if statement creates two paths: one when the condition is true and same is incremented, and another when the condition is false.
The fifth decision point is the if statement if (passwordLower.contains(user.getUsername().toLowerCase()) || password.length()<8). 
This creates two paths: one when the condition is true and the function returns false, and another when the condition is false.
Inside the else block, there is an if statement if (!passwordLower.contains(" ")). This creates two paths: one when the condition is true, and the loop is executed, and another when the condition is false.
Inside the loop, there is a for loop that iterates over the specialCharacters string. This loop has no decision points.
Considering these decision points, we have a total of 2 x 2 x 2 x 2 x 2 = 32 paths through the code. Therefore, the cyclomatic complexity of the given code is 32 + 1 = 33.

TASK 4:
Test case for the branch where user, password, and email are not null (A -> B -> C -> D -> E -> END):

Inputs:
User: Valid User object with non-null username, password, and email.
allUsers: Empty list or list of existing users.
Expected outcome: The function should return false since the password meets the criteria, but there are no existing users to check for duplicates.
Test case for the branch where user is null (A):

Inputs:
User: null
allUsers: Empty list or list of existing users.
Expected outcome: The function should throw a RuntimeException since the mandatory information is missing.
Test case for the branch where password is null (A):

Inputs:
User: Valid User object with non-null username and email, but password is null.
allUsers: Empty list or list of existing users.
Expected outcome: The function should throw a RuntimeException since the mandatory information is missing.
Test case for the branch where email is null (A):

Inputs:
User: Valid User object with non-null username and password, but email is null.
allUsers: Empty list or list of existing users.
Expected outcome: The function should throw a RuntimeException since the mandatory information is missing.
Test case for the branch where username is null (A -> B):

Inputs:
User: Valid User object with non-null password and email, but username is null.
allUsers: Empty list or list of existing users.
Expected outcome: The function should set the username as the email and continue to the next branch.
Test case for the branch where email and username are duplicates (A -> B -> C -> D):

Inputs:
User: Valid User object with non-null username, password, and email, where both email and username already exist in the list of existing users.
allUsers: List of existing users containing a user with the same email and username.
Expected outcome: The function should increment same twice but ultimately return false since the password contains the username.
Test case for the branch where password contains the username (A -> B -> C -> D):

Inputs:
User: Valid User object with non-null username, password, and email, where the password contains the username (case-insensitive).
allUsers: Empty list or list of existing users.
Expected outcome: The function should return false since the password contains the username.
Test case for the branch where password length is less than 8 (A -> B -> C -> D):

Inputs:
User: Valid User object with non-null username, password, and email, where the password length is less than 8 characters.
allUsers: Empty list or list of existing users.
Expected outcome: The function should return false since the password length is less than 8.
Test case for the branch where password contains no spaces but at least one special character (A -> B -> C -> D -> E):

Inputs:
User: Valid User object with non-null username, password, and email, where the password contains no spaces but at least one special character.
allUsers: Empty list or list of existing users.
Expected outcome: The function should return

TASK 5:

Test case: Null user
Explanation: In this test case, we pass a null user object. This should trigger the first condition user==null, resulting in the condition evaluating to true. The function should throw a RuntimeException with the message "Mandatory information missing!"

Test case: Null password
Explanation: In this test case, we pass a user object with a null password and non-null email. This should trigger the second condition user.getPassword()==null, resulting in the condition evaluating to true. The function should throw a RuntimeException with the message "Mandatory information missing!"

Test case: Null email
Explanation: In this test case, we pass a user object with a null email and non-null password. This should trigger the third condition user.getEmail()==null, resulting in the condition evaluating to true. The function should throw a RuntimeException with the message "Mandatory information missing!"

Test case: Null password and email
Explanation: In this test case, we pass a user object with both the password and email as null. This should trigger the second and third conditions, resulting in the condition evaluating to true. The function should throw a RuntimeException with the message "Mandatory information missing!"

Test case: Non-null user with valid password and email
Explanation: In this test case, we pass a user object with non-null password and email. This should make all three conditions user==null, user.getPassword()==null, and user.getEmail()==null evaluate to false, and the function should proceed without throwing an exception.