Monefy App - Exploratory Testing Session
---

Introduction
---
While performing the exploratory testing below charters were taken into consideration, these are capable of testing core app functionality as well as mobile application general aspects. 

## Testing Charters
* ### Charter 1 : Core functionality of the application
  * #### Purpose : To Validate the core functionality is not broken
  * #### Approach : 
    * Create income, expenses and validated them.
    * Create multiple accounts and validate income/expense with them.
    * Select multiple categories and validate income/expense addition in them.
    * Transfer amount and validate the change.
    * Select multiple currencies and validate income/expense in them.
    * Change setting and validate app behaviour based on settings.
    * Export the data and validate export functionality.


* ### Charter 2 : Environment support
    * #### Purpose : To Validate the app work in all supported environment
    * #### Approach :
        * Install/Upgrade on Android and iOS.
        * Install/Upgrade on multiple Android and iOS versions.
        * Permission management on different OS.

* ### Charter 3 : Performance
    * #### Purpose : To Validate the overall performance of the application
    * #### Approach :
        * Launch application and validate application launch time.
        * Let the app open for a while and monitor battery usage.
        * Use the app extensively and monitor CPU/RAM consumption.

* ### Charter 4 : Usability
    * #### Purpose : To Validate the app can be used by anyone
    * #### Approach :
        * Change language and validate localization.
        * Change currency and validate income / expense in different currency.
        * Swiping / Clicking on the app.
        * Filter based on Day, Week, Month or a custom date and validate them.

* ### Charter 5 : Premium paywall
    * #### Purpose : To Validate the use can not access premium features until paid
    * #### Approach :
        * User should not be able to use custom category like premium features.
        * User should be able to pay wand use premium features. (note : was not able to test)

_**Note** : Details of test cases are present at the end of the page to further prioritise the tests and making sure nothing is left._


## Key Bug Findings

| Bug                                         | Description                                                                                                      | Charter   | Steps to reproduce                                                                                                                                                                                            | Expected Result                                 | Actual Result                                                |
|---------------------------------------------|------------------------------------------------------------------------------------------------------------------|-----------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------|--------------------------------------------------------------|
| App is crashing while filtering with `Day`  | User can navigate between multiple filters, while selecting `Day` filter after `Interval` filter app is crashing | Usability | <ul><li>Open app and go to `Filters` by clicking on top left corner</li><li>Click on `Interval`</li><li>Select an Interval for previous two days</li><li>Now select `Day` again</li><li>Swipe right</li></ul> | User should be able to swipe                    | App is crashing                                              |
| Localization is not working                 | User can select a particular language but only few parts of the app are getting localized                        | Usability | <ul><li>Open app and go to `Settings`</li><li>Click on `Language`</li><li>Select `Deutsch` and click `OK`</li></ul>                                                                                           | Text should be localized in expense/income tab  | Open expense/income tab and chack text, it is not localized  |

## Prioritization of Charters

| Charter                               | Priority      | Reason for Priority                                                                                                  |
|---------------------------------------|---------------|----------------------------------------------------------------------------------------------------------------------|
| Core functionality of the application | P0 – Critical | Core functionalities, must be stable.                                                                                |
| Usability                             | P1 - High     | All users should be able to use application                                                                          |
| Environment support                   | P2 - Medium   | It should be based on the present data of devices used by customer, generally during development it is taken care of |
| Performance & Paywall                 | P3 - Low      | It is essential to test but core functionality is not broken.                                                        |

## Risk Areas & Recommendations
* **Study user trends:** We need to make sure on what kind of devices `Monefy` application is running and make sure to include environment testing for those.
* **Most used functionality:** We can setup monitors to make sure which functionality is amoung the most used one and prepare proper plans for it.
* **Data safety and security:** Data is the key and we need to make sure that the data is safe, secure and available all time even after the upgrade and rollback.
* **Subscription:** User is more sensitive when money is involved, we need to make sure that payment success, failure and rollback are being handled properly


---
Additional test case details based on charters
---
##### Scenario 1 : Install/Upgrade/Compatibility

  | Priority | Test Case Description | Expected Result |
      | -------- |---------------------- | --------------- |
  | `High Priority` | Installation of app from play store (android).| Installation should be successful.|
  | `High Priority` | Upgrade of app to the latest version | Validate the user data, settings. They should be same.|
  | `High Priority` | Installation of app on different devices & OS versions.| Validate the app should be installed.|
  | `High Priority` | Add & Remove required permission for app. | App should work fine in case of full and less permission.|
  | `High Priority` | Uninstall the app & install it again. | App should be uninstalled properly & after install data should be restored. |
  | `High Priority` | Validate App after system OS upgrade. | Validate the user data and app should work fine.|

##### Scenario 2 : Feature Especial

1. Account Feature

  | Priority | Test Case Description | Expected Result |
      | -------- |---------------------- | --------------- |
  | `High Priority` | Add an account with default parameters.| Account should be successfully created.|
  | `High Priority` | Edit the account details. | Updation should be successful.
  | `High Priority` | Delete the account. | Validate the account should be properly deleted and user income/expenses related to the account also deleted.|
  | `High Priority` | Create multiple account and switch between the account. | User should be able to switch between account properly and selected account data should be reflected. |

2. Income & Expense Feature

  | Priority | Test Case Description | Expected Result |
      | -------- |---------------------- | --------------- |
  | `High Priority` | Add Income and expenses for multiple categories | Income / Expense should be added & balance should be updated according to amount added.|
  | `High Priority` | Edit Income and expenses for multiple categories | Updation should be successful & balance should be updated according to amount edited. |
  | `High Priority` | Delete income and expenses for multiple categories | Validate the amount should be properly deleted & balance should be updated. |
  | `High Priority` | Change payment method while adding/updating expense | Account should be changeable while adding amount. |

3. Transfer Feature

  | Priority | Test Case Description | Expected Result |
      | -------- |---------------------- | --------------- |
  | `High Priority` | Click on New Transfer button from home page. | User should be able to view all the accounts. |
  | `High Priority` | Transfer amount from one account to another account. | Fund should be transferred and charts should be updated. |
  | `Low Priority` | Transfer amount from same account to same account. | User should not be able to transfer the amount. |

4. Pro Features

  | Priority | Test Case Description | Expected Result |
      | -------- |---------------------- | --------------- |
  | `High Priority` | As a free user, Access Pro features like custom category/Multi-currency/synchronization/Passcode etc. | Features should not be accessbile and prompt to buy monefy pro. |
  | `High Priority` | As a free user, Buy Monefy pro using different payment methods. | User should be able to buy pro. |
  | `High Priority` | As a pro user, Access Pro features like custom category/Multi-currency/synchronization/Passcode etc. | Features should be accessbile to the user. |

##### Scenario 3 : UI / Usability

  | Priority | Test Case Description | Expected Result |
      | -------- |---------------------- | --------------- |
  | `High Priority` | Change language to other lanuage. | Data should be present & and all the information should be localized. |
  | `High Priority` | Swipe balance button Up/down. | User should be able to swipe. |
  | `High Priority` | Select day/week/month/year/interval from filters. | User should be able to change filters and data/charts should be updated based on the filters. |
  | `Medium Priority` | Swipe left & right between Day/Weeks. | User should be able to swipe left and right. |
  | `Medium Priority` | Send app to background with multiple app and load it again. | App's state should be intact and data should be present. |

##### Scenario 4 : Settings
  (With/Without Pro)

  | Priority | Test Case Description | Expected Result |
      | -------- |---------------------- | --------------- |
  | `High Priority` | (Currency) Change currency to any other currency. | Data should be present & and all the information should be changed according to the currency. |
  | `High Priority` | (Export to file) Select Export to file option from settings | User should be prompted for permission of storage access and selected successfully. |
  | `High Priority` | (Export to file) Change "Character set"/"Decimal separator"/"Delimiter character" | Data should be present in all options & user should be able to change successfully. |
  | `High Priority` | (Export to file) Export data to csv file. | File should be saved and user should be able to access from file storage. |
  | `High Priority` | (About Monefy) Select the "About Monefy" from settings. | Data should be visible to the user |
  | `High Priority` | (About Monefy) Select links present on the "About Monefy" view. | All the links should be accessible & user should switch back to the app |
  | `High Priority` | (About Monefy) Disable/Enable google analytics. | Analytics should be switchable. |
  | `High Priority` | (Privacy Policy) Select "Privacy Policy" from settings | Used should be redirected to the monefy policy page & can switch back to app. |
  | `High Priority` | (Data Backup) Select "Create data Backup" from settings | User should be able to save the backup file. |
  | `High Priority` | (Data Backup) Select "Restore Data" from settings | User should be able to restore data from the backup file. |
  | `Meduim Priority` | (Data Backup) Select "Clear Data" from settings | All the data & data backup should be removed. |

  (With Pro)

  | Priority | Test Case Description | Expected Result |
      | -------- |---------------------- | --------------- |
  | `High Priority` | (Synchronization) Select Dropbox/Google Drive from settings | User should be able to view and export data from both the options. |
  | `High Priority` | (Synchronization) Select Dropbox/Google Drive and let it redirect. | User should be able to login to their account. |
  | `High Priority` | (Passcode Protection) Select a passcode from the settings. | Passcode should be available at app launch |
  | `High Priority` | (Passcode Protection) Launch app & enter passcode. | User should be able to access app. |
  | `Medium Priority` | (Dark theme) Select the dark theme from settings | App theme should be updated. |


Non-Functional Tests
---
##### Scenario 1 : Security

  | Priority | Test Case Description | Expected Result |
      | -------- |---------------------- | --------------- |
  | `High Priority` | Check for the application data saved. | Data should be encrypted. |
  | `High Priority` | Apply global phone lock passcode to app. | Lock should be applied and user should be able to access app after entering key |
  | `High Priority` | Check for vulnerability library used. | There should not be any vulnerability library present. |

##### Scenario 2 : Performance

  | Priority | Test Case Description | Expected Result |
      | -------- |---------------------- | --------------- |
  | `High Priority` | Battery usage of application. | Battery usage should not be rapid. |
  | `High Priority` | Battery usage of application while using internet and completing background tasks in battery save mode. | Battery usage should be optimized to prevent it from blocking. |
  | `High Priority` | Check for the application launch time. | Application launch time should not be more than specified or like (2 Seconds). |
  | `High Priority` | Extensive use of application. | Application should run without a crash. |
  | `High Priority` | Check for CPU/RAM consumption. | App should not over occupy CPU/RAM. |

##### Scenario 2 : Recovery

  | Priority | Test Case Description | Expected Result |
      | -------- |---------------------- | --------------- |
  | `High Priority` | Launch app after a crash. | App should perform well after the crash and data should not be lost. |
  | `High Priority` | Message on app crash. | User should be able to see crash message and can send crash report to the server. |
  | `High Priority` | App force shutdown from settings. | App should shutdown gracefully and data should be intact. |
  | `Medium Priority` | App shutdown due to battery dies. | App should be closed properly. |

##### Scenario 3 : Upgrade/Rollback

  | Priority | Test Case Description | Expected Result |
      | -------- |---------------------- | --------------- |
  | `High Priority` | Upgrade of app. | App should not over consume RAM. |
  | `High Priority` | Upgrade on low battery or error during upgrade. | Application should be rolled back propery when upgrade interuppted. |