# techbrunch-aws-lambda

This project is a quickstart guide to play with AWS Lambda in Java. We use Terraform to simplify the resource creation. The project consists of two parts:
- `aws-lambda-java`: A playground for you to implement and test your own Lambda functions.
- `aws-lambda-java-sample`: A sample solution with pre-implemented Lambda functions.

## Prerequisites

- JDK 21 installed
- Terraform installed
- AWS account
- Maven can be run with maven wrapper `./mvnw` or installed on your machine

## Project Structure

- `aws-lambda-java`: Contains the source code for your Lambda functions.
- `aws-lambda-java-sample`: Contains the sample solution with pre-implemented Lambda functions.
- `aws-lambda-java/readme.md`: Contains the instructions to implement and test your Lambda functions.

## References
https://docs.aws.amazon.com/lambda/latest/dg/java-handler.html
https://github.com/aws/aws-lambda-java-libs
https://github.com/awsdocs/aws-lambda-developer-guide
https://developer.hashicorp.com/terraform/tutorials/aws/lambda-api-gateway