# CHANGELOG
## [0.0.2-SNAPSHOT] - 2024-12-10
### Added
- Validation on parameters on parameters on GET /products/search. No negative value allowed.
- New exception for negative values. (NegativeValueNotAllowedException) 
- A new method on ExceptionService that overrides the one on the extended class. The purpose of this is to map all the errors into the ExceptionResponse template, so now every exception has the same structure.
- Tests to cover the new exception added works and to test if other possible exceptions are handled properly. 
### Fixed
- GET /products/search now takes 3 parameters instead of a body.
- Tests including the previous mentioned endpoint.