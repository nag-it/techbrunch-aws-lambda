# aws-lambda-java

This project is a quickstart guide to play with AWS Lambda in Java. Follow the steps below to install and test the Lambda functions.

## Prerequisites

- JDK21 installed
- Terraform installed
- AWS account
- Maven can be run with maven wrapper `./mvnw` or installed on your machine

## Step 1: Install `HelloHandler` Lambda with Terraform

1. Complete `variables.tf` file with:
   - AWS AccessKey and SecretKey
   - techbrunch_lambda_function_name bei replacing KURZEL with you Kürzel
2. Use `main.tf` file with to deploy the `Hello Lambdaler` Lambda function
https://developer.hashicorp.com/terraform/tutorials/aws/lambda-api-gateway#create-the-lambda-function

    ```terraform
    resource "aws_lambda_function" "hello_lambda" {
      function_name = "hello_lambda"
      role          = aws_iam_role.lambda_role.arn
      handler       = "ch.nag.techbrunch.awslambda.Hello::handleRequest"
      runtime       = "java21"
      timeout       = 15

      filename         = "aws-lambda-java/target/aws-lambda-java-1.0-SNAPSHOT.jar"
      source_code_hash = filebase64sha256("aws-lambda-java/target/aws-lambda-java-1.0-SNAPSHOT.jar")
    }
    ```

3. Run the following commands to deploy the Lambda function:

    ```sh
    terraform init
    terraform apply
    ```

## Step 2: Implement `HelloDude` and Install it with Terraform to see the Object that AWS Lambda is creating

1. Implement the `HelloDude` Lambda function in `HelloDude.java`:
2. Update `main.tf` to use the `HelloDude` Lambda function:
3. Run the following command to deploy the `HelloDude` Lambda function:

    ```sh
    terraform apply
    ```
4. run  the following command to test the `HelloDude` Lambda function:

    ```sh
    curl -X POST https://<FUNCTIONURL>.lambda-url.eu-central-1.on.aws/ -d "World"
    ```
   
## Step 3: Implement `HelloWeather` and Install it with Terraform to work with Objects

1. Implement the `HelloWeather` Lambda function in `HelloWeather.java`:
2. Update `main.tf` to use the `HelloWeather` Lambda function:
3. Run the following command to deploy the `HelloWeather` Lambda function:

    ```sh
    terraform apply
    ```
4. run  the following command to test the `HelloWeather` Lambda function:

    ```sh
    curl -H "content-type: application/json" -X POST https://<FUNCTIONURL>.lambda-url.eu-central-1.on.aws/ -d @weather-data-basel.json
    ```
   
## Step 4: Complete `main.tf` to Create an AWS API Gateway

1. Update `main.tf` file to redeploy the first Hello Lambda function in Hello.java
2Update `main.tf` to include the API Gateway configuration:
   https://developer.hashicorp.com/terraform/tutorials/aws/lambda-api-gateway#create-an-http-api-with-api-gateway
    ```terraform
    resource "aws_apigatewayv2_api" "lambda" {
      name          = "techbrunch_lambda_api"
      protocol_type = "HTTP"
    } ...
    ```

3.Run the following command to deploy the API Gateway:

    ```sh
    terraform apply
    ```
4.run the following command to test the API Gateway:

    ```sh
    curl https://<api-id>.execute-api.eu-central-1.amazonaws.com/hello
    ```

## Step 6: Implement `HelloApi` and Install it with Terraform

1. Implement the `HelloApi` Lambda function in `HelloApi.java`
2. Update `main.tf` to use the `HelloApi` Lambda function
3. Run the following command to deploy the `HelloApi` Lambda function:

    ```sh
    terraform apply
    ```

## Step 7: Test `HelloApi` with Curl

1. Use the following `curl` commands to test the `HelloApi`:

    ```sh
    curl -H "content-type: application/json" -X POST https://<api-id>.execute-api.eu-central-1.amazonaws.com/hello -d @weather-data-basel.json
    ```

