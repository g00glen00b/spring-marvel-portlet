# Marvel portlet collection
This project demonstrates a basic portlet application with the data provided by the Marvel REST API as business data.

## Installation
This project is tested on **WebSphere Portal 8**, but might work on other platforms as well. The only difference is that the portlet uses a custom portlet mode called **CONFIG** which is being used to setup the portlet.
When deploying, make sure the context of the application is **/wps/PA_Marvel**, otherwise web resources (CSS and JavaScript files) won't be loaded.

## Frameworks used
This portlet uses AngularJS and Semantic UI on the front-end. AngularJS is used to render the business data, while Semantic UI is used as UI framework.

On the back-end Spring portlet MVC is used in combination with Hibernate for form validation. Jersey is also used to retrieve the business data.

## Bower
Front end packages (jQuery, AngularJS, Moment.js and Semantic UI) are also under version control, but you can also choose to update them using Bower.
