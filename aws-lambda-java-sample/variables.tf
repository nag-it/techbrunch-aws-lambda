variable "aws_access_key" {
  description = "set aws access key"
  default = ""
}

variable "aws_secret_key" {
  description = "set aws secret key"
  default = ""
}

variable "techbrunch_lambda_function_name" {
  description = "The name of the Lambda function in AWS"
  default     = "techbrunch-lambda-KURZEL"
}

variable "techbrunch_lambda_jar" {
  description = "The name of the jar file to use"
  default     = "aws-lambda-java-1.0-SNAPSHOT.jar"
}