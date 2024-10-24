
provider "aws" {
  region = "eu-central-1"

  default_tags {
    tags = {
      environment = "techbrunch"
    }
  }

  access_key = var.aws_access_key
  secret_key = var.aws_secret_key

}

# Create the Lambda function
#
resource "aws_lambda_function" "hello_lambda" {
  function_name = var.techbrunch_lambda_function_name
  role          = aws_iam_role.lambda_exec.arn
  handler       = "ch.nag.techbrunch.awslambda.Hello::handleRequest"
  runtime       = "java21"
  timeout       = 15

  filename = "target/${var.techbrunch_lambda_jar}"
  source_code_hash = filebase64sha256("target/${var.techbrunch_lambda_jar}")

  environment {
    variables = {
      // Add environment variables here if needed
    }
  }
}

resource "aws_iam_role" "lambda_exec" {
  name = "serverless_lambda"

  assume_role_policy = jsonencode({
    Version = "2012-10-17"
    Statement = [{
      Action = "sts:AssumeRole"
      Effect = "Allow"
      Sid    = ""
      Principal = {
        Service = "lambda.amazonaws.com"
      }
    }
    ]
  })
}

resource "aws_iam_role_policy_attachment" "lambda_policy" {
  role       = aws_iam_role.lambda_exec.name
  policy_arn = "arn:aws:iam::aws:policy/service-role/AWSLambdaBasicExecutionRole"
}


# Create an HTTP API with API Gateway
#
# resource "aws_apigatewayv2_api" "lambda" {
#   name          = var.techbrunch_lambda_function_name
#   protocol_type = "HTTP"
# }
#
# ...

