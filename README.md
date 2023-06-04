Test cases for the site - https://dailytodo.org/. It's the simple site for creating todo lists, below you can see 3 test cases that cover main functionality of the site.

1)Check that user can create a new task
| Test Steps to Follow  | Expected result |
| ------------- | ------------- |
| Open the site https://dailytodo.org  | The main page of the site has been opened and it looks according to the design:![](https://github.com/BogdanShvetss/task/blob/master/src/test/resources/home_page.png)|
| Click on the "Create your Daily Todo list" button  | Screen with expty textarea has been opened and looks according to the design:  |
| Input some text in the text area and click on the "Save tasks" button | Your task has been saved and it's displayed on the page:  |
| Check that name of the task is the same as you've typed in the previous step | Task on the page has the same text as you've typed  |


2)Check that user can edit an existing task
| Test Steps to Follow  | Expected result |
| ------------- | ------------- |
| Open the site https://dailytodo.org  | The main page of the site has been opened and it looks according to the design: |
| Click on the "Create your Daily Todo list" button  | Screen with expty textarea has been opened and looks according to the design:  |
| Input some text in the text area and click on the "Save tasks" button | Your task has been saved and it's displayed on the page:  |
| Click on the "Edit" link | Screen with textarea has been opened  |
| Change name of a task to new and click on the "Save tasks" button| Your task has been changed and it's displayed on the page:  |

3)Check that user can see a history of tasks completion
| Test Steps to Follow  | Expected result |
| ------------- | ------------- |
| Open the site https://dailytodo.org  | The main page of the site has been opened and it looks according to the design: |
| Click on the "Create your Daily Todo list" button  | Screen with expty textarea has been opened and looks according to the design:  |
| Input some text in the text area and click on the "Save tasks" button | Your task has been saved and it's displayed on the page:  |
| Click on the checkbox in "Today" column to mark your task as finished | Checkbox has a green color |
| Click on the "»" button in "Older" column| New page has been opened and it look according to the design:  |
| Find today date in table with dates (the last block) and chech it's color|block of today's date in history has a green color |
| Return to the previous page and click on the checkbox in "Today" column to mark your task as unfinished | Checkbox doesn't have any color |
| Click on the "»" button in "Older" column| New page has been opened and it look according to the design:  |
| Find today date in table with dates (the last block) and chech it's color|block of today's date in history has a red color |
