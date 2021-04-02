#!/usr/bin/python3
import subprocess
import os.path

test_inputs = []
test_outputs = []


def test_have_resources():
    """ Tests that the program is built and has all the necessary files
    and data ready
    """


    # test all needed files exist (compiled class file + test case files)
    assert os.path.exists('./Encryptor.class') and os.path.isfile('./Encryptor.class')
    assert os.path.exists('./test_data/test_input.txt') and os.path.isfile('./test_data/test_input.txt')
    assert os.path.exists('./test_data/test_output.txt') and os.path.isfile('./test_data/test_output.txt')

    global test_inputs
    global test_outputs
    
    # ensure text files are readable and have the same number of lines
    with open('test_data/test_input.txt') as in_data:
        test_inputs = [s.strip() for s in in_data.readlines()]
    
    with open('test_data/test_output.txt') as out_data:
        test_outputs = [s.strip() for s in out_data.readlines()]
    
    assert len(test_inputs) == len(test_outputs)

def test_encryptor():
    """ Tests that the Encryptor class functions as expected """


    for input_str, expected_out in zip(test_inputs, test_outputs):
        program_output = subprocess.check_output(['java', 'Encryptor', input_str]).decode('utf-8').strip()
        assert expected_out == program_output

