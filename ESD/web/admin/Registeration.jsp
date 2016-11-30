<%-- 
    Document   : Registeration
    Created on : 19-Nov-2016
    Author     : m2-abdalla
    Date modified: 28-Nov-2016 
    Author of Modification: Jodrin Rodrigues
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            /* sets the map height explicitly to define the size of the div
             * element that contains the map. */
            #map {
                height: 100%;
            }
            
            html, body {
                height: 100%;

                padding: 0;
            }
        </style>
        <link type="text/css" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500">
        <style>
            #locationField, #controls {
                margin-left: 40%;
                position: relative;
                width: 300px;
            }
            #autocomplete {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 99%;
            }
            .label {
                text-align: right;
                width: 100px;
            }
            #address {
                width: 385px;
                padding-right: 40px;
                
                margin-left: 37%;
            }
            .field {
                width: 99%;
            }
            .slimField {
                width: 60px;
                padding-right: 4px;
            }
            .wideField {
                width: 20px;
                
            }
            #locationField {
                height: 20px;
                margin-bottom: 2px;
            }
        </style>
    </head>
    <body>
        <h1 align="center"> Registration Form </h1>
        <form align="center" 
              action ="welcome.jsp" method="POST">

            First name:<br>
            <input type="text" name="firstname"  align="center" required><br>
            Last name:<br>
            <input   type="text" name="lastname" required><br>
            Address:<br>

            <div id="locationField">
                <input id="autocomplete" placeholder="Enter your address"
                       onFocus="geolocate()" type="text"></input>
            </div>

            <table id="address">
                <tr>
                    <td class="label">Street address</td>
                    <td class="slimField"><input class="field" id="street_number"
                                                 disabled="true"></input></td>
                    <td class="wideField" colspan="2"><input class="field" id="route"
                                                             disabled="true"></input></td>
                </tr>
                <tr>
                    <td class="label">City/town</td>
                   
                    <td class="wideField" colspan="3"><input class="field" id="locality"
                                                             disabled="true"></input></td>
                </tr>
                <tr>
                  
                    <td class="label">Post code</td>
                    <td class="wideField"><input class="field" id="postal_code"
                                                 disabled="true"></input></td>
                </tr>
                <tr>
                    <td class="label">Country</td>
                    <td class="wideField" colspan="3"><input class="field"
                                                             id="country" disabled="true"></input></td>
                </tr>
            </table>
            <br>
            Date Of Birth:<br>
            <input type="date" name="DOB" required><br>
            Date of Registration:<br>
            <input type="date" name="date of registration" required><br>
            <input type="submit" value="Submit">
        </form>
        <script>
            // This example displays an address form, using the autocomplete feature
            // of the Google Places API to help users fill in the information.

            // This example requires the Places library. Include the libraries=places
            // parameter when you first load the API. For example:
            // <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=places">

            var placeSearch, autocomplete;
            var componentForm = {
                street_number: 'short_name',
                route: 'long_name',
                locality: 'long_name',
                country: 'long_name',
                postal_code: 'short_name'
            };

            function initAutocomplete() {
                // Create the autocomplete object, restricting the search to geographical
                // location types.
                autocomplete = new google.maps.places.Autocomplete(
                        /** @type {!HTMLInputElement} */(document.getElementById('autocomplete')),
                        {types: ['geocode']});

                // When the user selects an address from the dropdown, populate the address
                // fields in the form.
                autocomplete.addListener('place_changed', fillInAddress);
            }

            function fillInAddress() {
                // Get the place details from the autocomplete object.
                var place = autocomplete.getPlace();

                for (var component in componentForm) {
                    document.getElementById(component).value = '';
                    document.getElementById(component).disabled = false;
                }

                // Get each component of the address from the place details
                // and fill the corresponding field on the form.
                for (var i = 0; i < place.address_components.length; i++) {
                    var addressType = place.address_components[i].types[0];
                    if (componentForm[addressType]) {
                        var val = place.address_components[i][componentForm[addressType]];
                        document.getElementById(addressType).value = val;
                    }
                }
            }

            // Bias the autocomplete object to the user's geographical location,
            // as supplied by the browser's 'navigator.geolocation' object.
            function geolocate() {
                if (navigator.geolocation) {
                    navigator.geolocation.getCurrentPosition(function (position) {
                        var geolocation = {
                            lat: position.coords.latitude,
                            lng: position.coords.longitude
                        };
                        var circle = new google.maps.Circle({
                            center: geolocation,
                            radius: position.coords.accuracy
                        });
                        autocomplete.setBounds(circle.getBounds());
                    });
                }
            }
        </script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAFDiFTw_fAAdVY7GFdLEvdycGwvCKS40k&libraries=places&callback=initAutocomplete"
        async defer></script>
    </body>
</html>
