A coursework done in my first year.
A GUI is built to display patient information, and this data can be uploaded to an SQL database
This coursework was done using PostgreSQL (pgAdmin4).

Run the 'Main' class. After creating a database and loading a CSV file in the GUI, click the 'Load SQL Database' button and enter your jdb Driver Connection URL, and your PostGreSQL username and password into the input field.

An example URL is <jdbc:postgresql://localhost:5432/patient_data>, where
'5432' should be the port name used,
'patient_data' should be the name of the database.

If all goes well, a table should be added in the SQL database, and the terminal
should print out "Connection Established". After reloading the page, the new
table can be seen under the data base.
