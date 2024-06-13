package com.example.hla;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TopicsActivuty extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView topicsListView;
    private String[] topics = {
            " 1) Adders",
            " 2) Logic Gates",
            " 3) FET",
            " 4) Photo Cell",
            " 5) Phototransistor",
            " 6) Det of H",
            " 7) CB Transistor",
            " 8) CE Transistor",
            " 9) P-N Diode",
            " 10) Zener Diode",
            " Special "
    };
    String[] imageResourceNames = {"halfadder","and","fet","photovoltaic","photottransistor","plankcircuit","cbtrans","cecircuit","pncir","zenercir","lock"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_topics_activuty);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView topicsListView = findViewById(R.id.topicsListView);
        Customtopicadapter adapter = new Customtopicadapter(this, topics, imageResourceNames);
        topicsListView.setAdapter(adapter);

        topicsListView.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String selectedTopic = topics[position];
        //String description = "Description for " + topics[position];
        Bundle dataBundle = new Bundle();
        dataBundle.putString("topic", selectedTopic);
        //dataBundle.putString("description", description);

        if(position == 0){
            String[] ques_obj = {
                    " Q1. What are the two basic digits used in the binary number system?",
                    " Q2. How does binary addition differ from decimal addition?",
                    " Q3. Explain the steps involved in performing binary addition by hand.",
                    " Q4. Add the following binary numbers: 1101 + 1010",
                    " Q5. How can binary subtraction be performed?",
                    " Q6. Find the 2's complement of the binary number 100.",
                    " Q7. Subtract 100 from 1011 using binary addition and 2's complement.",
                    " Q8. Describe what happens when an overflow occurs in binary addition.",
                    " Q9. What is the purpose of a half adder?",
                    " Q10. Explain the logic behind the carry output in a half adder.",
                    " Q11. What is the key difference between a half adder and a full adder?",
                    " Q12. Describe the concept of carry-in and carry-out in a full adder."
            };

            String[] ans_obj = {
                    " Ans1) 0 and 1",
                    " Ans2) Binary uses only 0 and 1, considers carry bits for sums > 1.",
                    " Ans3) Start from LSB, add bits, carry 1 if sum > 1, repeat for all bits.",
                    " Ans4) 10001 (Carry 1)",
                    " Ans5) Add the 2's complement of the subtrahend to the minuend.",
                    " Ans6) 011 (Invert all bits and add 1)",
                    " Ans7) Find 2's complement of 100 (011), add 1011 + 011 = 1110 (ignore carry).",
                    " Ans8) Overflow occurs when the sum of two bits exceeds 1, carry bit becomes 1 but no space for extra value (incorrect result if not handled).",
                    " Ans9) A half adder adds two single-bit binary numbers, outputs sum and carry.",
                    " Ans10) Carry output is 1 only when both input bits (A and B) are 1, indicating a carry over.",
                    " Ans11) Half adder adds 2 bits, full adder adds 3 bits (A, B, and carry-in).",
                    " Ans12) Carry-in is a carry bit from previous addition, carry-out indicates carry over to next bit position in a full adder."
            };

            String [] img_obj = {
                    "halfadder",
                    "halfaddertable",
                    "fulladder",
                    "fulladdertable"
            };
            dataBundle.putStringArray("questions",ques_obj);
            dataBundle.putStringArray("answers",ans_obj);
            dataBundle.putStringArray("images",img_obj);
      }
        else if(position == 1){
            String[] ques_obj = {
                    " Q1) What are the basic logic gates?",
                    " Q2) Explain the truth table of an AND gate.",
                    " Q3) Describe the functionality of a NOT gate.",
                    " Q4) What is the difference between a NAND gate and an AND gate?",
                    " Q5) Explain the applications of a NOR gate.",
                    " Q6) What is the output of an XOR gate when both inputs are 0?",
                    " Q7) Can you explain the concept of a universal logic gate?",
                    " Q8) How are logic gates used in digital circuits?",
                    " Q9) What is the binary number system?",
                    " Q10) How do you convert a decimal number to binary?",
                    " Q11) Explain the concept of overflow in binary addition.",
                    " Q12) How can binary subtraction be performed?"
            };

            String[] ans_obj = {
                    "Ans1) The basic logic gates are AND, OR, NOT, NAND, NOR, and XOR.",
                    "Ans2) | A | B | Output |\n" +
                            "|---|---|-------|\n" +
                            "| 0 | 0 | 0      |\n" +
                            "| 0 | 1 | 0      |\n" +
                            "| 1 | 0 | 0      |\n" +
                            "| 1 | 1 | 1      |",
                    "Ans3) A NOT gate inverts the input signal. If the input is 0, the output is 1. Conversely, if the input is 1, the output is 0.",
                    "Ans4) An AND gate outputs 1 only when both inputs are 1. A NAND gate outputs 1 only when both inputs are 0 (opposite of AND). In other cases, a NAND gate outputs 0.",
                    "Ans5) NOR gates can be used to implement various logic functions:\n" +
                            "- NOT (using a single input)\n" +
                            "- OR (using additional inverters)\n" +
                            "- Memory elements (latches)",
                    "Ans6) The output of an XOR gate is 0 when both inputs are the same (both 0 or both 1). When the inputs are different (one 0 and one 1), the output is 1.",
                    "Ans7) A universal logic gate is a single gate that can be used to implement any other logic function. Examples include NAND and NOR gates, as they can be combined to create other logic gates.",
                    "Ans8) Logic gates are the fundamental building blocks of digital circuits. By combining these gates, we can create complex logic functions used in processors, memory controllers, and various digital devices.",
                    "Ans9) The binary number system is a base-2 system that uses only two digits: 0 and 1. It represents information using combinations of these digits.",
                    "Ans10) There are various methods, like repeated division by 2 and collecting remainders (until the quotient becomes 0). The remainders, read from bottom to top, represent the binary equivalent.",
                    "Ans11) Overflow occurs when the sum of two binary digits exceeds 1. In this case, the carry bit becomes 1, but there's no additional bit position to store the extra value (unlike decimal addition). This can lead to incorrect results if not handled properly.",
                    "Ans12) Binary subtraction can be done by adding the 2's complement of the subtrahend (second number) to the minuend (first number). The 2's complement is found by inverting all bits and adding 1."
            };
            String [] img_obj = {
                    "and",
                    "or",
                    "not",
                    "nand",
                    "nor",
                    "xor"
            };
            dataBundle.putStringArray("questions",ques_obj);
            dataBundle.putStringArray("answers",ans_obj);
            dataBundle.putStringArray("images",img_obj);
      }
        else if(position == 2){
            String[] ques_obj = {
                    "Q1) What is a Field Effect Transistor (FET)?",
                    "Q2) Explain the basic operation of an n-channel JFET.",
                    "Q3) What are drain and transfer characteristics in an FET?",
                    "Q4) Describe the concept of pinch-off voltage (Vp) in a JFET.",
                    "Q5) What is the amplification factor (µ) of an FET?",
                    "Q6) How is transconductance (gm) defined in an FET?",
                    "Q7) Briefly compare enhancement mode and depletion mode FETs.",
                    "Q8) Why are FETs preferred over BJTs in certain applications?",
                    "Q9) Explain the concept of biasing in an FET circuit.",
                    "Q10) How does the type of biasing method affect the stability of an FET circuit?"
            };

            String[] ans_obj = {
                    "Ans1) An FET is a transistor that utilizes an electric field to control current flow. It uses voltage instead of current (unlike BJTs).",
                    "Ans2) In an n-channel JFET, a depletion region controls current by applying a reverse bias to the gate. A more negative Vgs pinches off the channel, reducing current.",
                    "Ans3) Drain characteristics show Id vs Vds for various Vgs. Transfer characteristics show Id vs Vgs for a constant Vds.",
                    "Ans4) Pinch-off voltage (Vp) is the negative Vgs at which the depletion region completely pinches off the channel, leading to minimal drain current.",
                    "Ans5) The amplification factor (µ) represents the change in Id for a unit change in Vgs at a constant Vds. It reflects how effectively the gate controls current.",
                    "Ans6) Transconductance (gm) is another term for the amplification factor (µ). It's measured in Siemens (S) and indicates how easily the gate modulates the drain current.",
                    "Ans7) Enhancement mode FETs require a positive Vgs to induce a channel and allow current. Depletion mode FETs have a conducting channel by default, and a negative Vgs reduces current.",
                    "Ans8) FETs offer high input impedance, lower power consumption, better temperature stability, and are smaller for easier integration in circuits compared to BJTs.",
                    "Ans9) Biasing establishes a stable operating point for an FET by setting appropriate voltages on the gate, drain, and source terminals for optimal amplification or switching.",
                    "Ans10) Biasing methods can influence stability. Fixed-bias is simple but susceptible to temperature variations. Voltage divider bias offers better stability. Self-bias uses drain current for biasing, providing good stability but requiring additional elements."
            };

            String [] img_obj = {
                    "fet",
                    "draincharfet",
                    "transfercharfet"
            };
            dataBundle.putStringArray("questions",ques_obj);
            dataBundle.putStringArray("answers",ans_obj);
            dataBundle.putStringArray("images",img_obj);
      }
        else if(position == 3){
            String[] ques_obj = {
                    "Q1) What is a photovoltaic cell?",
                    "Q2) Explain the basic principle behind the photovoltaic effect.",
                    "Q3) What type of material is commonly used in photovoltaic cells?",
                    "Q4) Describe the p-n junction in a photovoltaic cell.",
                    "Q5) What happens to light energy when it strikes a photovoltaic cell?",
                    "Q6) What are the main factors affecting the efficiency of a photovoltaic cell?",
                    "Q7) How is the power output of a photovoltaic cell measured?",
                    "Q8) What is the difference between open-circuit voltage (Voc) and short-circuit current (Isc) of a solar cell?",
                    "Q9) Explain the concept of the I-V characteristic curve of a photovoltaic cell.",
                    "Q10) What are some applications of photovoltaic cells?"
            };

            String[] ans_obj = {
                    "Ans1) A photovoltaic cell is a device that converts light energy directly into electrical energy through the photovoltaic effect.",
                    "Ans2) When light strikes a photovoltaic cell, it excites electrons in the material, creating electron-hole pairs. These free electrons can flow through the cell, generating an electric current.",
                    "Ans3) Silicon is the most common material used in photovoltaic cells due to its abundance, relatively low cost, and good light-absorbing properties.",
                    "Ans4) A p-n junction is formed by joining p-type and n-type semiconductor layers in the cell. This creates an electric field that separates the electron-hole pairs generated by light, allowing current flow.",
                    "Ans5) Light energy excites electrons in the p-n junction, creating electron-hole pairs. These electrons move towards the n-type region, and holes move towards the p-type region, generating a current.",
                    "Ans6) Several factors affect photovoltaic cell efficiency: light intensity, spectrum of light, material properties, temperature, and manufacturing defects.",
                    "Ans7) The power output of a photovoltaic cell is measured in watts (W) and is typically determined under standard test conditions (STC) of irradiance and temperature.",
                    "Ans8) Open-circuit voltage (Voc) is the maximum voltage a solar cell can produce when no current is flowing (open circuit). Short-circuit current (Isc) is the maximum current a solar cell can generate when its terminals are shorted (zero voltage).",
                    "Ans9) The I-V characteristic curve shows the relationship between the current (I) and voltage (V) of a photovoltaic cell. It helps determine the operating point and efficiency of the cell.",
                    "Ans10) Photovoltaic cells have various applications, including powering homes, businesses, and remote locations, and in solar chargers, electric vehicles, and large-scale solar power plants."
            };

            String [] img_obj = {
                    "photovoltaic",
                    "photovoltaicchar",
                    "photovoltaiccurve"
            };
            dataBundle.putStringArray("questions",ques_obj);
            dataBundle.putStringArray("answers",ans_obj);
            dataBundle.putStringArray("images",img_obj);
      }
        else if(position == 4){
            String[] ques_obj = {
                    "Q1) What is a phototransistor?",
                    "Q2) How does a phototransistor differ from a regular transistor?",
                    "Q3) Explain the principle of operation in a phototransistor.",
                    "Q4) What type of light is typically used to activate a phototransistor?",
                    "Q5) Describe the main characteristics of a phototransistor.",
                    "Q6) What is the difference between sensitivity and spectral response in a phototransistor?",
                    "Q7) What are some advantages and disadvantages of using phototransistors?",
                    "Q8) How can the linearity of a phototransistor be affected?",
                    "Q9) Explain the concept of dark current in a phototransistor.",
                    "Q10) What are some applications of phototransistors?"
            };

            String[] ans_obj = {
                    "Ans1) A phototransistor is a light-sensitive transistor that converts light energy into electrical current. It's similar to a regular transistor but has a light-sensitive base region.",
                    "Ans2) Unlike a regular transistor controlled by a base current, a phototransistor's base current is generated by incident light striking its base region.",
                    "Ans3) When light strikes the base region of a phototransistor, it excites electrons, creating a base current. This base current amplifies the collector current, similar to a regular transistor.",
                    "Ans4) Phototransistors typically respond best to specific wavelengths of light, such as infrared (IR) or visible light, depending on the material used.",
                    "Ans5) Key characteristics of a phototransistor include: sensitivity (responsiveness to light), spectral response (wavelength sensitivity), collector-emitter saturation voltage, and speed of response.",
                    "Ans6) Sensitivity refers to the amount of collector current generated for a given light intensity. Spectral response describes the variation in sensitivity across different light wavelengths.",
                    "Ans7) Advantages: high sensitivity, isolation between input (light) and output (current), compact size. Disadvantages: limited bandwidth, temperature sensitivity, noise susceptibility.",
                    "Ans8) Linearity can be affected by factors like high light intensity causing saturation or non-uniform illumination across the base region.",
                    "Ans9) Dark current is a small leakage current that flows through the phototransistor even in the absence of light. It's important to minimize dark current for precise light detection.",
                    "Ans10) Phototransistors are used in various applications: object detection (e.g., line following robots), light sensing in security systems, optical encoders, and optocouplers."
            };

            String [] img_obj = {
                    "photottransistor",
                    "phototransistorchar"
            };
            dataBundle.putStringArray("questions",ques_obj);
            dataBundle.putStringArray("answers",ans_obj);
            dataBundle.putStringArray("images",img_obj);
      }
        else if(position == 5){
            String[] ques_obj = {
                    "Q1) What is Planck's constant?",
                    "Q2) How does the experiment using LEDs help determine Planck's constant?",
                    "Q3) Explain the relationship between light energy and wavelength in the context of this experiment.",
                    "Q4) What is the significance of the 'knee voltage' observed in the experiment with LEDs?",
                    "Q5) Describe the process of measuring the current and voltage across an LED in this experiment.",
                    "Q6) How is the data obtained from the experiment used to calculate Planck's constant?",
                    "Q7) What factors can introduce error in the determination of Planck's constant using LEDs?",
                    "Q8) Why are LEDs preferred over other light sources for this experiment?",
                    "Q9) What safety precautions should be taken while performing this experiment?",
                    "Q10) Are there alternative methods for determining Planck's constant?"
            };

            String[] ans_obj = {
                    "Ans1) Planck's constant (h) is a fundamental physical constant relating the energy (E) of a light quantum (photon) to its frequency (ν) by the equation E = hν.",
                    "Ans2) This experiment measures the voltage needed to forward bias an LED and cause it to emit light. By knowing the LED's wavelength and the relationship between voltage and energy, Planck's constant can be calculated.",
                    "Ans3) Light energy is inversely proportional to its wavelength. Shorter wavelengths (higher frequencies) have higher energy.",
                    "Ans4) The knee voltage is the minimum voltage required to overcome the energy barrier in the LED and initiate light emission. It's related to the bandgap energy of the LED material.",
                    "Ans5) The current through the LED is typically measured with a milliammeter, and the voltage across the LED is measured with a voltmeter.",
                    "Ans6) By plotting the measured voltage versus the known wavelength of the LED (obtained from its color), a relationship can be established. Using this relationship and the equation E = eV (where e is electron charge), Planck's constant (h) can be calculated from the slope.",
                    "Ans7) Errors can arise from various factors: limitations of measuring instruments, non-ideal behavior of LEDs (e.g., series resistance), and variations in LED color within a specific range.",
                    "Ans8) LEDs offer a relatively narrow and well-defined wavelength emission compared to other light sources, simplifying the experiment.",
                    "Ans9) It's important to use proper circuit components with appropriate ratings and follow basic laboratory safety protocols.",
                    "Ans10) Yes, other methods exist, such as blackbody radiation experiments or photoelectric effect experiments, but the LED experiment offers a simpler and relatively accessible approach."
            };


            String [] img_obj = {
                    "plankcircuit",
                    "plankchar"
            };
            dataBundle.putStringArray("questions",ques_obj);
            dataBundle.putStringArray("answers",ans_obj);
            dataBundle.putStringArray("images",img_obj);
      }
        else if(position == 6){
            String[] ques_obj = {
                    "Q1) What is the common-base (CB) transistor configuration?",
                    "Q2) How does the CB configuration differ from common-emitter (CE) and common-collector (CC) configurations?",
                    "Q3) Explain the relationship between the terminals in a common-base transistor.",
                    "Q4) Describe the input and output characteristics of a CB transistor.",
                    "Q5) What is the main advantage of using a common-base configuration?",
                    "Q6) What are some limitations of the common-base configuration compared to CE or CC?",
                    "Q7) How does the current gain (β) of a transistor relate to the CB configuration?",
                    "Q8) Explain the concept of voltage gain in a common-base transistor.",
                    "Q9) When might a common-base configuration be preferred over CE or CC?",
                    "Q10) What are some applications of common-base transistors?"
            };

            String[] ans_obj = {
                    "Ans1) In the common-base (CB) configuration, the base terminal is shared between the input and output signals. The emitter acts as the input, and the collector acts as the output.",
                    "Ans2) Unlike CE (common-emitter) where the emitter is common, and CC (common-collector) where the collector is common, the CB configuration has the base as the reference point for both input and output.",
                    "Ans3) In CB, the base is common (shared), the emitter injects current (input), and the collector collects current (output).",
                    "Ans4) The input characteristic shows the variation of emitter current (IE) with emitter-base voltage (VEB) for different collector-base voltages (VCB). The output characteristic shows the variation of collector current (IC) with collector-base voltage (VCB) for different emitter currents (IE).",
                    "Ans5) The main advantage of CB is its high input impedance. The base acts like a high-impedance point due to the very small base current.",
                    "Ans6) Limitations include: low voltage gain (less than 1), lower output power capability compared to CE, and the requirement for a voltage source to bias the base.",
                    "Ans7) The current gain (β) of a transistor relates to the ratio of collector current (IC) to base current (IB) in CE configuration. It's indirectly related to CB as CB doesn't directly utilize base current for control.",
                    "Ans8) Voltage gain in a CB transistor is typically less than 1. It's calculated as the change in collector voltage (ΔVC) divided by the change in emitter-base voltage (ΔVEB) for a constant collector current (IC).",
                    "Ans9) CB might be preferred when a high input impedance is crucial, for impedance matching in RF circuits, or when dealing with very high-frequency signals due to its wider bandwidth compared to CE.",
                    "Ans10) Common-base transistors can be used in RF amplifiers (for impedance matching), voltage-to-current converters, and cascode amplifiers (combining CB and CE stages for high input impedance and high gain)."
            };


            String [] img_obj = {
                    "cbtrans",
                    "cbinput",
                    "cboutput"
            };
            dataBundle.putStringArray("questions",ques_obj);
            dataBundle.putStringArray("answers",ans_obj);
            dataBundle.putStringArray("images",img_obj);
      }
        else if(position == 7){
            String[] ques_obj = {
                    "Q1) What is the common-emitter (CE) transistor configuration?",
                    "Q2) How does the CE configuration differ from common-base (CB) and common-collector (CC) configurations?",
                    "Q3) Explain the relationship between the terminals in a common-emitter transistor.",
                    "Q4) Describe the input and output characteristics of a CE transistor.",
                    "Q5) What are the main advantages of using a common-emitter configuration?",
                    "Q6) What are some limitations of the common-emitter configuration?",
                    "Q7) How does the current gain (β) of a transistor relate to the CE configuration?",
                    "Q8) Explain the concept of voltage gain in a common-emitter transistor.",
                    "Q9) Why is the common-emitter configuration the most widely used transistor configuration?",
                    "Q10) What are some applications of common-emitter transistors?"
            };

            String[] ans_obj = {
                    "Ans1) In the common-emitter (CE) configuration, the emitter is shared between the input and output circuits. The base is the input terminal, and the collector acts as the output.",
                    "Ans2) Unlike CB (common-base) where the base is common, and CC (common-collector) where the collector is common, the CE configuration has the emitter as the reference point for both input and output.",
                    "Ans3) In CE, the emitter is common (shared), the base controls current with a small base current (input), and the collector delivers amplified current (output).",
                    "Ans4) The input characteristic shows the variation of base current (IB) with base-emitter voltage (VBE) for different collector currents (IC). The output characteristic shows the variation of collector current (IC) with collector-emitter voltage (VCE) for different base currents (IB).",
                    "Ans5) The main advantages of CE are: high voltage gain (greater than 1), high current gain (β), and a relatively low input impedance, making it easier to drive with voltage sources.",
                    "Ans6) Limitations include: lower input impedance compared to CB, and a requirement for current amplification (β) to be significant for proper operation.",
                    "Ans7) The current gain (β) of a transistor is a crucial parameter in CE. It's the ratio of collector current (IC) to base current (IB), signifying how effectively a small base current controls a larger collector current.",
                    "Ans8) Voltage gain in a CE transistor is typically greater than 1. It's calculated as the change in collector voltage (ΔVC) divided by the change in base-emitter voltage (ΔVBE) for a constant collector current (IC).",
                    "Ans9) The CE configuration is the most widely used due to its high voltage and current gain, making it ideal for amplification applications. Its lower input impedance allows easier interfacing with voltage sources.",
                    "Ans10) Common-emitter transistors are used in a vast array of applications, including audio amplifiers, voltage regulators, switching circuits, logic gates, and various electronic devices."
            };


            String [] img_obj = {
                    "cecircuit",
                    "ceinput",
                    "ceoutput"
            };
            dataBundle.putStringArray("questions",ques_obj);
            dataBundle.putStringArray("answers",ans_obj);
            dataBundle.putStringArray("images",img_obj);
      }
        else if(position == 8){
            String[] ques_obj = {
                    "Q1) What is a p-n diode?",
                    "Q2) Explain the formation of a p-n junction in a diode.",
                    "Q3) Describe the biasing conditions for a p-n diode (forward bias and reverse bias).",
                    "Q4) What happens to the depletion region in a p-n diode under forward and reverse bias?",
                    "Q5) How does a p-n diode conduct current under forward bias?",
                    "Q6) What is the significance of the knee voltage in a p-n diode?",
                    "Q7) Explain the concept of reverse saturation current in a p-n diode.",
                    "Q8) Describe the I-V characteristic curve of a p-n diode.",
                    "Q9) What are some important parameters of a p-n diode?",
                    "Q10) What are some applications of p-n diodes?"
            };

            String[] ans_obj = {
                    "Ans1) A p-n diode is a fundamental semiconductor device formed by joining p-type and n-type semiconductor regions. It allows current flow in one direction and significantly restricts current in the opposite direction.",
                    "Ans2) A p-n junction is created by joining p-type (with an excess of holes) and n-type (with an excess of electrons) regions. This creates a depletion region where mobile charge carriers are depleted due to diffusion.",
                    "Ans3) There are two main biasing conditions:  \n" +
                            "- Forward bias: Positive voltage applied to the anode (p-type) and negative voltage to the cathode (n-type). \n" +
                            "- Reverse bias: Positive voltage applied to the cathode and negative voltage to the anode.",
                    "Ans4) Under forward bias, the depletion region narrows, allowing majority carriers (holes in p and electrons in n) to inject current across the junction. Under reverse bias, the depletion region widens, significantly reducing current flow.",
                    "Ans5) In forward bias, majority carriers overcome the potential barrier at the depletion region due to the applied voltage, allowing current to flow from anode to cathode.",
                    "Ans6) The knee voltage is the minimum forward bias voltage required for significant current flow to begin. It represents the voltage needed to overcome the potential barrier at the depletion region.",
                    "Ans7) Reverse saturation current (Is) is a small leakage current that flows even under reverse bias due to minority carriers and thermal generation.",
                    "Ans8) The I-V characteristic curve shows the relationship between current (I) and voltage (V) across the diode. It depicts a low current region for reverse bias, a sharp increase in current for forward bias beyond the knee voltage, and a non-linear behavior.",
                    "Ans9) Important parameters include: forward voltage drop, reverse saturation current, breakdown voltage (maximum reverse voltage), and capacitance.",
                    "Ans10) P-n diodes have numerous applications, including rectification (converting AC to DC), signal detection, clipping and clamping circuits, voltage regulation, and light-emitting diodes (LEDs)."
            };



            String [] img_obj = {
                    "pncir",
                    "pnchar"
            };
            dataBundle.putStringArray("questions",ques_obj);
            dataBundle.putStringArray("answers",ans_obj);
            dataBundle.putStringArray("images",img_obj);
      }
        else if(position == 9){
            String[] ques_obj = {
                    "Q1) What is a Zener diode?",
                    "Q2) How does a Zener diode differ from a regular p-n diode?",
                    "Q3) Explain the principle of operation in a Zener diode under reverse bias.",
                    "Q4) What is the breakdown voltage (Vz) of a Zener diode?",
                    "Q5) Describe the Zener breakdown mechanism.",
                    "Q6) What are the main characteristics of a Zener diode?",
                    "Q7) How is the Zener diode used for voltage regulation?",
                    "Q8) What are some limitations of using Zener diodes for voltage regulation?",
                    "Q9) What are some safety considerations when using Zener diodes?",
                    "Q10) What are some applications of Zener diodes besides voltage regulation?"
            };

            String[] ans_obj = {
                    "Ans1) A Zener diode is a special type of p-n junction diode designed to operate in the reverse breakdown region. It allows a controlled flow of current in the reverse direction when a specific voltage is reached.",
                    "Ans2) Unlike a regular p-n diode with a high reverse resistance, a Zener diode has a much lower breakdown voltage (Vz). It's specifically designed for controlled breakdown.",
                    "Ans3) Under reverse bias, when the voltage reaches the breakdown voltage (Vz), a phenomenon called Zener breakdown occurs, allowing significant current flow in the reverse direction.",
                    "Ans4) The breakdown voltage (Vz) is the critical reverse voltage at which the Zener diode breaks down and conducts current. This voltage is a key parameter for a Zener diode.",
                    "Ans5) Zener breakdown involves two mechanisms:  \n" +
                            "- Zener effect: Tunneling of electrons from the valence band of the p-region to the conduction band of the n-region due to the high electric field. \n" +
                            "- Avalanche breakdown: Collisions of electrons with atoms in the depletion region, creating additional electron-hole pairs and a rapid increase in current.",
                    "Ans6) Main characteristics include: breakdown voltage (Vz), maximum reverse current (Iz), temperature coefficient (how Vz varies with temperature), and dynamic impedance (resistance offered by the Zener diode in breakdown).",
                    "Ans7) Zener diodes are used in voltage regulation circuits. When connected in reverse bias with a voltage source and a load, they maintain a constant voltage across the load by shunting excess current when the source voltage exceeds the Zener voltage.",
                    "Ans8) Limitations include: power dissipation limitations (Zener diodes can only handle a certain amount of power), temperature dependence of breakdown voltage, and limited voltage regulation range for a single Zener diode.",
                    "Ans9) It's crucial to choose a Zener diode with appropriate power rating to handle the expected current and avoid overheating.  Reverse voltage exceeding the maximum rating can damage the diode.",
                    "Ans10) Zener diodes have various applications beyond voltage regulation: voltage clipping (limiting voltage peaks), voltage reference sources, transient voltage suppression (protecting circuits from voltage spikes), and temperature compensation circuits."
            };



            String [] img_obj = {
                    "zenercir",
                    "zenerchar"
            };
            dataBundle.putStringArray("questions",ques_obj);
            dataBundle.putStringArray("answers",ans_obj);
            dataBundle.putStringArray("images",img_obj);
      }


       else{
            Intent intent = new Intent(this, SpecialPurpose.class);
            startActivity(intent);
       }



        openTopicDetailsPage(dataBundle);
    }

    public void openTopicDetailsPage(Bundle dataBundle) {
        Intent intent = new Intent(this, TopicDetails.class);
        intent.putExtras(dataBundle);
        startActivity(intent);
    }
}