#Homework for hashes
# have to turn in a text file. this pythib file is for running command libes/code in linux

##SECTION  1:
# At a Linux command line prompt, create three files by issuing the following commands:
# $ echo "this is file 1" > cs471-a
# $ cp /bin/yes cs471-b
# $ echo "this is file 1" > cs471-c


#import hashlib
import hashlib

def get_hash(file_path):
    #2.1: Get hash of following: Sha256 and MD5
    sha256_hash = hashlib.sha256()
    md5_hash = hashlib.md5()
    #2.4 - more objects for other functions
    sha1_hash = hashlib.sha1()
    sha384_hash = hashlib.sha384()
    sha512_hash = hashlib.sha512()

    
    # read file
    with open(file_path, 'rb') as f:
        data = f.read()  
        # get the hashes "updated"
        sha256_hash.update(data)  
        md5_hash.update(data)
        #2.4 - more hashes being updated
        sha1_hash.update(data)
        sha384_hash.update(data)
        sha512_hash.update(data)

    #return the valules of hashes 
    return (
        sha256_hash.hexdigest(),
        md5_hash.hexdigest(),
        #2.4 - more hash values
        sha1_hash.hexdigest(),
        sha384_hash.hexdigest(),
        sha512_hash.hexdigest()
    )

#files = cs471-a , b, and c in array for cleaner code
files = ["cs471-a", "cs471-b", "cs471-c"]  

# Open the file and write hashes 
with open('hashes.txt', 'w') as hash_file:  
    #loop through all files 
    for file_name in files:
        #get hashes of files
        sha256_digest = get_hash(file_name)
        md5_digest = get_hash(file_name)
        sha1_digest = get_hash(file_name)
        sha384_digest = get_hash(file_name)
        sha512_digest = get_hash(file_name)
        #place them in hashes.txt
        hash_file.write(f"{file_name} hash (sha256): {sha256_digest}\n  hash(MD5): {md5_digest}\n"
                        f"hash (sha1): {sha1_digest}\n fhash (sha384): {sha384_digest}\n"
                        f"hash (sha512): {sha512_digest}\n")

print("hashes saved in hashes.txt.")

