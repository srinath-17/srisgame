import time

# Create the start.sh file
with open("start.sh", "w") as f:
    f.write("#!/bin/bash\n")
    f.write("# Hi Srinath")

# Wait for 10 minutes
time.sleep(600)
