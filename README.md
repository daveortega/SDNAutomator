# Automating Daily File Transfer to a Solaris Server

## Overview

In 2012, we implemented an automated solution to streamline the process of downloading a file from a remote server and uploading it to a Solaris server using FTP. This automation replaced a manual task, ensuring that the file was always up-to-date without requiring daily human intervention.

## Implementation Details

### Steps Involved

1. **Downloading the File**: The program downloaded the required file from a specified remote URL to a local directory.
2. **FTP Connection to Solaris Server**: The program established an FTP connection to the Solaris server.
3. **Uploading the File**: The downloaded file was then uploaded to the designated directory on the Solaris server.
4. **Automation**: The entire process was automated to run daily, eliminating the need for manual operation.

As part of this project, there were other .bat files responsible to create the ftp connection and place the file to be processed.
