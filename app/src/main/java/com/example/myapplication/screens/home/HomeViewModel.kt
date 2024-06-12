package com.example.myapplication.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.database.Topic

class HomeViewModel(val model: HomeModel) : ViewModel() {
    private var _topics = MutableLiveData(mutableListOf<Topic>())
    val topics: LiveData<MutableList<Topic>> = _topics

    val database = listOf(
        Topic(name = "Nanotechnology: Manipulating Matter at the Atomic Scale", description = "Unveiling the Mysteries of Quantum Entanglement Implications of Zero-Point Energy: A Look Into Vacuum Fluctuations Examining the Principles and Potential of Nuclear Fusion Harnessing Antimatter: Theoretical Approaches and Practical Limitations Tracing Cosmic Rays: Sources, Propagation, and Interaction with Matter Advanced Gravitational Waves: Detection and Significance Rethinking Dark Matter: Contemporary Views and Hypotheses Probing Planetary Physics: Dynamics in Our Solar System Exploring the Physics of Black Holes: Beyond the Event Horizon."),
        Topic(name = "Relativity Theory: Spacetime Curvature and Gravitational Lenses", description = "Unveiling the Mysteries of Quantum Entanglement Implications of Zero-Point Energy: A Look Into Vacuum Fluctuations Examining the Principles and Potential of Nuclear Fusion Harnessing Antimatter: Theoretical Approaches and Practical Limitations Tracing Cosmic Rays: Sources, Propagation, and Interaction with Matter Advanced Gravitational Waves: Detection and Significance Rethinking Dark Matter: Contemporary Views and Hypotheses Probing Planetary Physics: Dynamics in Our Solar System Exploring the Physics of Black Holes: Beyond the Event Horizon."),
        Topic(name = "Nanotechnology: Manipulating Matter at the Atomic Scale", description = "Unveiling the Mysteries of Quantum Entanglement Implications of Zero-Point Energy: A Look Into Vacuum Fluctuations Examining the Principles and Potential of Nuclear Fusion Harnessing Antimatter: Theoretical Approaches and Practical Limitations Tracing Cosmic Rays: Sources, Propagation, and Interaction with Matter Advanced Gravitational Waves: Detection and Significance Rethinking Dark Matter: Contemporary Views and Hypotheses Probing Planetary Physics: Dynamics in Our Solar System Exploring the Physics of Black Holes: Beyond the Event Horizon."),
        Topic(name = "Relativity Theory: Spacetime Curvature and Gravitational Lenses", description = "Unveiling the Mysteries of Quantum Entanglement Implications of Zero-Point Energy: A Look Into Vacuum Fluctuations Examining the Principles and Potential of Nuclear Fusion Harnessing Antimatter: Theoretical Approaches and Practical Limitations Tracing Cosmic Rays: Sources, Propagation, and Interaction with Matter Advanced Gravitational Waves: Detection and Significance Rethinking Dark Matter: Contemporary Views and Hypotheses Probing Planetary Physics: Dynamics in Our Solar System Exploring the Physics of Black Holes: Beyond the Event Horizon."),
        Topic(name = "Nanotechnology: Manipulating Matter at the Atomic Scale", description = "Unveiling the Mysteries of Quantum Entanglement Implications of Zero-Point Energy: A Look Into Vacuum Fluctuations Examining the Principles and Potential of Nuclear Fusion Harnessing Antimatter: Theoretical Approaches and Practical Limitations Tracing Cosmic Rays: Sources, Propagation, and Interaction with Matter Advanced Gravitational Waves: Detection and Significance Rethinking Dark Matter: Contemporary Views and Hypotheses Probing Planetary Physics: Dynamics in Our Solar System Exploring the Physics of Black Holes: Beyond the Event Horizon."),
        Topic(name = "Relativity Theory: Spacetime Curvature and Gravitational Lenses", description = "Unveiling the Mysteries of Quantum Entanglement Implications of Zero-Point Energy: A Look Into Vacuum Fluctuations Examining the Principles and Potential of Nuclear Fusion Harnessing Antimatter: Theoretical Approaches and Practical Limitations Tracing Cosmic Rays: Sources, Propagation, and Interaction with Matter Advanced Gravitational Waves: Detection and Significance Rethinking Dark Matter: Contemporary Views and Hypotheses Probing Planetary Physics: Dynamics in Our Solar System Exploring the Physics of Black Holes: Beyond the Event Horizon."),
        Topic(name = "Nanotechnology: Manipulating Matter at the Atomic Scale", description = "Unveiling the Mysteries of Quantum Entanglement Implications of Zero-Point Energy: A Look Into Vacuum Fluctuations Examining the Principles and Potential of Nuclear Fusion Harnessing Antimatter: Theoretical Approaches and Practical Limitations Tracing Cosmic Rays: Sources, Propagation, and Interaction with Matter Advanced Gravitational Waves: Detection and Significance Rethinking Dark Matter: Contemporary Views and Hypotheses Probing Planetary Physics: Dynamics in Our Solar System Exploring the Physics of Black Holes: Beyond the Event Horizon."),
        Topic(name = "Relativity Theory: Spacetime Curvature and Gravitational Lenses", description = "Unveiling the Mysteries of Quantum Entanglement Implications of Zero-Point Energy: A Look Into Vacuum Fluctuations Examining the Principles and Potential of Nuclear Fusion Harnessing Antimatter: Theoretical Approaches and Practical Limitations Tracing Cosmic Rays: Sources, Propagation, and Interaction with Matter Advanced Gravitational Waves: Detection and Significance Rethinking Dark Matter: Contemporary Views and Hypotheses Probing Planetary Physics: Dynamics in Our Solar System Exploring the Physics of Black Holes: Beyond the Event Horizon."),
        )

    init {
        if (model.isFirstRun()) addItems()
        getItems()
    }

    private fun getItems() {
        _topics.value = model.getItems()
    }

    private fun addItems() {
        for (topic in database) {
            model.addItem(topic)
        }
    }
}