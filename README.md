You can run this tests using any IDE

Or if you have installed Maven you can run tests using it

To run all API tests run in terminal
```mvn '-Dtest=api.*Test' test```

For UI test use
```mvn '-Dtest=ui.tests.*Test' test```

After running tests, you can check report
If you have installed Allure you can run
```allure serve```

Example of report:
![report](https://user-images.githubusercontent.com/35080265/197028483-9b6a83a6-9233-4cc7-bcc5-dc6378e8a6ce.png)
