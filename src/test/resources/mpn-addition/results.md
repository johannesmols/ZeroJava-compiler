# Adding of 7 and 6 digits

```text
-----------------------------------------------------------------------------------------
| Results of ZeroJava-compiler/src/test/resources/mpn-addition/MpnAddition.zmips        |
-----------------------------------------------------------------------------------------
| Answer (decimal)   = 1                                                                |
| 64-bit answer      = 0000000000000000000000000000000000000000000000000000000000000001 |
| Timesteps required = 867                                                              |
-----------------------------------------------------------------------------------------

-------------------------------------------------------------
| BAIR Specifications                                       |
-------------------------------------------------------------
| field size                                     = 2^64     |
| number of variables per state (w)              = 572      |
| number of regular constraints (s)              = 559      |
| number of permutation constraints              = 514      |
| number of cycles (c)                           = (2^10)-1 |
| degree of constraint system (d)                = 13       |
| degree of permutation constraint system        = 5        |
| number of boundary constraints (B)             = 10       |
| number of variables used by constraint systems = 571      |
| number of variables routed                     = 4        |
| number of variables not routed                 = 568      |
-------------------------------------------------------------
---------------------------------------------------
| ACSP Specifications                             |
---------------------------------------------------
| field size                             = 2^64   |
| number of algebraic-registers (|\Tau|) = 46     |
| number of neighbors (|N|)              = 766    |
| vanishing space size                   = 2^18   |
| composition degree bound               = 688115 |
---------------------------------------------------
-------------------------------------------------------------
| APR Specifications                                        |
-------------------------------------------------------------
| field size                                       = 2^64   |
| number of algebraic-registers (|\Tau|)           = 46     |
| number of neighbors (|N|)                        = 766    |
| witness (f) evaluation space size (|L|)          = 2^24   |
| constraint (g) evaluation space size (|L_{cmp}|) = 2^22   |
| witness (f) maximal rate (\rho_{max})            = 2^{-9} |
| constraint (g) rate (\rho_{cmp})                 = 2^{-3} |
| zero knowledge parameter (k)                     = 1      |
| rate parameter (R)                               = 3      |
| constraints degree log (d)                       = 19     |
-------------------------------------------------------------
Constructing APR (ACSP) witness:....(1.63515 seconds)
-----------------------------------------
| FRI for witness (f) specifications #1 |
-----------------------------------------
| field size (|F|)      = 2^64          |
| RS code dimension     = 2^15          |
| RS block-length       = 2^24          |
| RS code rate          = 2^-{9}        |
| Soundness error       = 2^-{61}       |
| dim L_0 (eta)         = 2             |
| recursion depth       = 7             |
| COMMIT repetitions    = 2             |
| number of tests (ell) = 7             |
-----------------------------------------
---------------------------------------------
| FRI for constraints (g) specifications #1 |
---------------------------------------------
| field size (|F|)      = 2^64              |
| RS code dimension     = 2^19              |
| RS block-length       = 2^22              |
| RS code rate          = 2^-{3}            |
| Soundness error       = 2^-{61}           |
| dim L_0 (eta)         = 2                 |
| recursion depth       = 9                 |
| COMMIT repetitions    = 2                 |
| number of tests (ell) = 21                |
---------------------------------------------
Verifier decision: ACCEPT
------------------------------------------------------
| Protocol execution measurements                    |
------------------------------------------------------
| Prover time                    = 2.858557 Minutes  |
| Verifier time                  = 0.323227 Seconds  |
| Total proof oracles size       = 16.750000 GBytes  |
| Total communication complexity = 1.456253 MBytes   |
| Query complexity               = 515.515625 KBytes |
------------------------------------------------------
```

# Adding 67 and 67 digits

```text
-----------------------------------------------------------------------------------------
| Results of ZeroJava-compiler/src/test/resources/mpn-addition/MpnAddition.zmips        |
-----------------------------------------------------------------------------------------
| Answer (decimal)   = 1                                                                |
| 64-bit answer      = 0000000000000000000000000000000000000000000000000000000000000001 |
| Timesteps required = 7924                                                             |
-----------------------------------------------------------------------------------------

-------------------------------------------------------------
| BAIR Specifications                                       |
-------------------------------------------------------------
| field size                                     = 2^64     |
| number of variables per state (w)              = 573      |
| number of regular constraints (s)              = 559      |
| number of permutation constraints              = 514      |
| number of cycles (c)                           = (2^13)-1 |
| degree of constraint system (d)                = 14       |
| degree of permutation constraint system        = 5        |
| number of boundary constraints (B)             = 11       |
| number of variables used by constraint systems = 572      |
| number of variables routed                     = 4        |
| number of variables not routed                 = 569      |
-------------------------------------------------------------
----------------------------------------------------
| ACSP Specifications                              |
----------------------------------------------------
| field size                             = 2^64    |
| number of algebraic-registers (|\Tau|) = 46      |
| number of neighbors (|N|)              = 769     |
| vanishing space size                   = 2^21    |
| composition degree bound               = 5767154 |
----------------------------------------------------
-------------------------------------------------------------
| APR Specifications                                        |
-------------------------------------------------------------
| field size                                       = 2^64   |
| number of algebraic-registers (|\Tau|)           = 46     |
| number of neighbors (|N|)                        = 769    |
| witness (f) evaluation space size (|L|)          = 2^27   |
| constraint (g) evaluation space size (|L_{cmp}|) = 2^25   |
| witness (f) maximal rate (\rho_{max})            = 2^{-9} |
| constraint (g) rate (\rho_{cmp})                 = 2^{-3} |
| zero knowledge parameter (k)                     = 1      |
| rate parameter (R)                               = 3      |
| constraints degree log (d)                       = 22     |
-------------------------------------------------------------
Constructing APR (ACSP) witness:.....(2.5955 seconds)
-----------------------------------------
| FRI for witness (f) specifications #1 |
-----------------------------------------
| field size (|F|)      = 2^64          |
| RS code dimension     = 2^18          |
| RS block-length       = 2^27          |
| RS code rate          = 2^-{9}        |
| Soundness error       = 2^-{61}       |
| dim L_0 (eta)         = 2             |
| recursion depth       = 9             |
| COMMIT repetitions    = 2             |
| number of tests (ell) = 7             |
-----------------------------------------
---------------------------------------------
| FRI for constraints (g) specifications #1 |
---------------------------------------------
| field size (|F|)      = 2^64              |
| RS code dimension     = 2^22              |
| RS block-length       = 2^25              |
| RS code rate          = 2^-{3}            |
| Soundness error       = 2^-{61}           |
| dim L_0 (eta)         = 2                 |
| recursion depth       = 11                |
| COMMIT repetitions    = 2                 |
| number of tests (ell) = 21                |
---------------------------------------------
Verifier decision: REJECT
------------------------------------------------------
| Protocol execution measurements                    |
------------------------------------------------------
| Prover time                    = 21.599140 Minutes |
| Verifier time                  = 0.641461 Seconds  |
| Total proof oracles size       = 134.000000 GBytes |
| Total communication complexity = 1.564056 MBytes   |
| Query complexity               = 511.000000 KBytes |
------------------------------------------------------
```