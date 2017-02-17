## Data Operation Syntax

______
|Keywords|Syntax|Behavior
|---|---|---|
|load|load path/to/file.ext|Loads a file into data batch. Will report an error if file doesn't exist or file is unparsable.
|save|save batchName path/to/file.ext|Saves the designated batch to the designated file. Will check if overwrite permitted if file already exists at destination.
|find|find category=value[,category=value]|Finds and displays all instances where category=value in all batches. Batches can be designated as well to search only that Batch for matching parameters.
|update|update category=value[,category=value] with category=value[,category=value]|Will update the defined values according to category parameters. Will update all occurrences of specified category combinations. Will check if batchName not specified.
______
