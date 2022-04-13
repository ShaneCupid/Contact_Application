# Contact or "Phonebook" application

In this project, I wrote an application that creates and stores contacts. It can store information about people and organizations. In this app, you can store phone numbers of different people and different companies, like your favorite pizza shop or your bank.

I have a base class named "Contact" that contains information relevant to both an organization and a person, such as name, phone number (which would be a String) and createdAt (which would be the datetime when the object was created).

My Contact class has a stand-alone verifier that validates if a phone number entered by the user is valid or not. This is used by different applications by passing the string phone number as a parameter. This method is a stand-alone logic and hence can be called without having to create an object of Contact. Simplicity was the goal for this feature

On my execution or main method class I had several actions that helped make this code run succesfully. 
Components of main method class which contained our user interaction options:
add: Asks the user whether they want to add a person or organization. Based on their choice, display the questions pertaining to that Contact type which is of person or organization. Lastly, this creates the contact object and stores it in your phonebook list.
list: This method simply displays each contact in this format -> id.name
count: This method displays the number of records saved in the phonebook
info: This method ask the user to imput contact id. If there was an id previously saved then the program would display that contacts information. 
delete: This method deletes the contact the user inputed from the phonebook
search: query function asking user to insert any key attribute to make identifying a contact, business or anything else easier. 
exit: this method ends user interaction and closes the application

note - I created a file reader to store every contact created. 
