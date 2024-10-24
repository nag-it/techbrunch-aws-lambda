terraform {
  /*
  cloud {
    workspaces {
      name = "terraform-aws-lambda"
    }
  } */
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.38.0"
    }
  }
}