# Rappi
Ejercicio de prueba para Rappi

El proceso seleccionado para automatizar fue una simple implementación de Selenium(Chrome)+TestNG+Maven

La prueba utiliza la página de demostración http://newtours.demoaut.com y se encarga de hacer el login y los subsecuentes pasos para hacer el booking de un vuelo de avión. Verifica tanto la existencia de los elementos como la correcta URL en cada paso.

Se utiliza una clase base para hacer el setup del driver y luego una clase de test específica. También los locators para cada elemento están contenidos en su propia clase constants, siguiendo patrones de Page Object Model.

Para correr los tests simplemente tener chromedriver en el PATH o bien crear un directorio /bin dentro del proyecto y ponerlo ahí.

matias.matteucci@gmail.com
